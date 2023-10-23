package com.api.rest.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "opcion")
public class OpcionModel {

  @Id
  @GeneratedValue
  @Column(name = "OPCION_ID")
  private Long Id;

  private String value;

  public OpcionModel() {
  }

  public OpcionModel(Long Id, String value) {
    this.Id = Id;
    this.value = value;
  }

  public Long getId() {
    return this.Id;
  }

  public void setId(Long Id) {
    this.Id = Id;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
