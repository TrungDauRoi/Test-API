package com.deahansi.event;

import com.deahansi.base.event.DrivenEventListener;
import com.deahansi.base.event.EventInfo;
import com.deahansi.feign.FirebaseClient;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ServiceDrivenEventListener extends DrivenEventListener {

  @Value("${app.firebase-config}")
  private String fireBaseConfig;


  private final FirebaseClient firebaseClient;

  @Autowired
  public ServiceDrivenEventListener(
      ThreadPoolTaskExecutor threadPoolTaskExecutor,
      ApplicationContext applicationContext,
      FirebaseClient firebaseClient) {
    super(applicationContext, threadPoolTaskExecutor);
    this.firebaseClient = firebaseClient;
  }

  @Override
  protected void processLogHandleEventAsync(EventInfo eventInfo) {}

  @Override
  protected void processHandleErrorEventAsync(EventInfo eventInfo) {}

  @SuppressWarnings({"unchecked", "unused"})
  public void handleEventPushMsgToFCM(Object data) throws FirebaseMessagingException {

  }
}
