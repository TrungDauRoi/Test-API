package com.deahansi.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum LicensingType {
  NEW(1, "Cấp mới"),
  RENEW(2, "Cấp lại"),
  EXTEND(3, "Gia hạn"),
  ADJUST(4, "Điều chỉnh");

  private Integer code;

  private String name;

  LicensingType(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  public static boolean contains(Integer code) {
    for (LicensingType c : LicensingType.values()) {
      if (c.getCode().equals(code)) {
        return true;
      }
    }
    return false;
  }

  public static LicensingType getByCode(Integer code) {
    return Stream.of(LicensingType.values())
        .filter(lt -> lt.getCode() == code)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

}
