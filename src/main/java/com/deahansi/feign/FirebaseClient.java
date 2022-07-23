package com.deahansi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "firebase", url = "https://fcm.googleapis.com", decode404 = true)
public interface FirebaseClient {

}
