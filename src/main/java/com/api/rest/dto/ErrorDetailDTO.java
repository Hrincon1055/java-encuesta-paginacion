package com.api.rest.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorDetailDTO {
  private String title;
  private int status;
  private String detail;
  private long timeStamp;
  private String DeveloperMessage;
  private Map<String, List<ValidationErrorDTO>> errors = new HashMap<>();

  public ErrorDetailDTO() {
  }

  public ErrorDetailDTO(String title, int status, String detail, long timeStamp, String DeveloperMessage,
      Map<String, List<ValidationErrorDTO>> errors) {
    this.title = title;
    this.status = status;
    this.detail = detail;
    this.timeStamp = timeStamp;
    this.DeveloperMessage = DeveloperMessage;
    this.errors = errors;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getDetail() {
    return this.detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public long getTimeStamp() {
    return this.timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getDeveloperMessage() {
    return this.DeveloperMessage;
  }

  public void setDeveloperMessage(String DeveloperMessage) {
    this.DeveloperMessage = DeveloperMessage;
  }

  public Map<String, List<ValidationErrorDTO>> getErrors() {
    return this.errors;
  }

  public void setErrors(Map<String, List<ValidationErrorDTO>> errors) {
    this.errors = errors;
  }

}
