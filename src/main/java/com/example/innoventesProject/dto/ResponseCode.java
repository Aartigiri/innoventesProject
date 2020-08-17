package com.example.innoventesProject.dto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ResponseCode {

  SUCCESS(10000, "SUCCESS"),

  FAIL(10001, "FAIL"),

  UNKNOWN_ERROR_OCCURRED(10002, "UNKNOWN_ERROR_OCCURRED");

  private final int code;

  private final String message;

  private static final Map<Integer, ResponseCode> responseCodeMap =
      Arrays.asList(com.example.innoventesProject.dto.ResponseCode.values()).stream()
          .collect(Collectors.toMap(com.example.innoventesProject.dto.ResponseCode::getCode, Function.identity()));

  ResponseCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public static com.example.innoventesProject.dto.ResponseCode valueOf(int value) {
    if (responseCodeMap.containsKey(value)) {
      return responseCodeMap.get(value);
    }
    throw new IllegalArgumentException("No matching constant for [" + value + "]");
  }

  @Override
  public String toString() {
    return this.code + " " + this.message;
  }

}
