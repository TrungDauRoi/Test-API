package com.deahansi;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
@EnableSwagger2
@EnableCaching
@EntityScan(basePackages = "com.deahansi.entity")
@EnableJpaRepositories(basePackages = "com.deahansi.repository")
@SpringBootApplication
public class MainApplication {

  @Value("${service.thread.pool.task.executor.core.pool.size}")
  private int corePoolSize;

  @Value("${service.thread.pool.task.executor.max.pool.size}")
  private int maxPoolSize;

  @Value("${service.thread.pool.task.executor.queue.capacity}")
  private int queueCapacity;

  public static void main(String[] args) {
    String localIp = getLocalIp();
    assert localIp != null;
    System.setProperty("localIpValue", localIp);
    SpringApplication.run(MainApplication.class, args);
  }

  public static String getLocalIp() {
    InetAddress result = null;
    try {
      int lowest = Integer.MAX_VALUE;
      for (Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces(); nics.hasMoreElements();) {
        NetworkInterface ifc = nics.nextElement();
        if (ifc.isUp()) {
          if (ifc.getIndex() < lowest || result == null) {
            lowest = ifc.getIndex();
          } else {
            continue;
          }

          // @formatter:off
          for (Enumeration<InetAddress> addrs = ifc.getInetAddresses(); addrs.hasMoreElements(); ) {
            InetAddress address = addrs.nextElement();
            if (address instanceof Inet4Address && !address.isLoopbackAddress()) {
              result = address;
            }
          }
          // @formatter:on
        }
      }
    } catch (IOException ignored) {

    }

    if (result != null) {
      return result.getHostAddress();
    }

    try {
      return InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException ignored) {

    }

    return null;
  }

  @Bean
  public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
    var executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setQueueCapacity(queueCapacity);
    executor.setThreadNamePrefix("service-task_executor-");
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.initialize();
    return executor;
  }
}
