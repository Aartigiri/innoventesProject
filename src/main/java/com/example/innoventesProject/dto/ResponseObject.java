package com.example.innoventesProject.dto;



import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject<T> {

  private ResponseStatus status;

  private T response;


  public ResponseObject() {
    super();
  }


  public ResponseObject(ResponseConstants responseConstant) {
    this.status = new ResponseStatus(responseConstant.getCode(), responseConstant.getDesc());
  }

  public ResponseObject(ResponseStatus responseStatus) {
    this.status = responseStatus;
  }

  public ResponseObject(T response, ResponseConstants responseConstant) {
    this.response = response;
    this.status = new ResponseStatus(responseConstant.getCode(), responseConstant.getDesc());
  }

  public ResponseObject(T response) {
    this.response=response;
  }

  public ResponseObject(ResponseStatusCode valueOf) {
  }

  public ResponseObject(ResponseStatusCode invalidRequestParameter, Map<String, String> errors) {
  }

  public T getResponse() {
    return response;
  }

  public void setResponse(T response) {
    this.response = response;
  }

  public ResponseStatus getStatus() {
    return status;
  }

  public void setStatus(ResponseStatus status) {
    this.status = status;
  }

  public static <T> com.example.innoventesProject.dto.ResponseObject<T> success(T response) {
    return new com.example.innoventesProject.dto.ResponseObject<>(response);
  }

  @Override
  public String toString() {
    return "ResponseObject{" +
        "status=" + status +
        ", response=" + response +
        '}';
  }
}
