package com.api.rest.dto;

public class OpcionCountDTO {
  private Long opcionId;
  private int count;

  public OpcionCountDTO() {
  }

  public OpcionCountDTO(Long opcionId, int count) {
    this.opcionId = opcionId;
    this.count = count;
  }

  public Long getOpcionId() {
    return this.opcionId;
  }

  public void setOpcionId(Long opcionId) {
    this.opcionId = opcionId;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }

}
