package com.deahansi.enums;
import java.util.stream.Stream;


public enum ProtocolMethod {
	FTP("FTP"), MQTT("MQTT");
	private String protocolMethod;

	ProtocolMethod(String value) {
        this.protocolMethod = value;
    }

    public String getProtocolMethod() {
        return protocolMethod;
    }

    public static ProtocolMethod of(String value) {
        return Stream.of(ProtocolMethod.values())
                .filter(p -> p.getProtocolMethod() == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
