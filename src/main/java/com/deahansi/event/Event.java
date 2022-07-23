package com.deahansi.event;

import com.deahansi.base.event.CoreEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Event implements CoreEvent {

  PUSH_MSG_TO_FCM("handleEventPushMsgToFCM", "serviceDrivenEventListener");

  private final String handleEventFunctionName;

  private final String handleEventBeanName;

  @Override
  public String getEventName() {
    return this.name();
  }
}
