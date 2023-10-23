package com.api.rest.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "voto")
public class VotoModel {
  @Id
  @GeneratedValue
  @Column(name = "VOTO_ID")
  private Long Id;

  @ManyToOne
  @JoinColumn(name = "OPCION_ID")
  private OpcionModel opcion;

  public VotoModel() {
  }

  public VotoModel(Long Id, OpcionModel opcion) {
    this.Id = Id;
    this.opcion = opcion;
  }

  public Long getId() {
    return this.Id;
  }

  public void setId(Long Id) {
    this.Id = Id;
  }

  public OpcionModel getOpcion() {
    return this.opcion;
  }

  public void setOpcion(OpcionModel opcion) {
    this.opcion = opcion;
  }

}
