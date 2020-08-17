package com.example.innoventesProject.dto;



import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {

  private int code;

  private String message;

  private Map<String, String> errorMap;

  private Long timestamp = new Date().getTime();


  public ResponseStatus(ResponseCode responseCode) {
    this(responseCode.getCode(), responseCode.getMessage());
  }

  public ResponseStatus(ResponseCode statusCode, String actualErrorMessage) {
    this(statusCode.getCode(), actualErrorMessage);
  }

  public ResponseStatus(ResponseCode statusCode, Map<String, String> errorMap) {
    this(statusCode.getCode(), statusCode.getMessage());
    this.errorMap = errorMap;
  }

  public ResponseStatus(int code, String message) {
    super();
    this.code = code;
    this.message = message;
  }

  public ResponseStatus(ResponseConstants badCredentials) {
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, String> getErrorMap() {
    return errorMap;
  }

  public void setErrorMap(Map<String, String> errorMap) {
    this.errorMap = errorMap;
  }

  public Long getTimestamp() {
    return timestamp;
  }

}
