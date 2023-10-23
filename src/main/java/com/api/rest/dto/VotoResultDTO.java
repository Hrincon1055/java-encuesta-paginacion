package com.api.rest.dto;

import java.util.Collection;

public class VotoResultDTO {
  private Integer totalVotos;
  private Collection<OpcionCountDTO> result;

  public VotoResultDTO() {
  }

  public VotoResultDTO(Integer totalVotos, Collection<OpcionCountDTO> result) {
    this.totalVotos = totalVotos;
    this.result = result;
  }

  public Integer getTotalVotos() {
    return this.totalVotos;
  }

  public void setTotalVotos(Integer totalVotos) {
    this.totalVotos = totalVotos;
  }

  public Collection<OpcionCountDTO> getResult() {
    return this.result;
  }

  public void setResult(Collection<OpcionCountDTO> result) {
    this.result = result;
  }

}
