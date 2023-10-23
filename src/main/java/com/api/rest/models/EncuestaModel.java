package com.api.rest.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "encuesta")
public class EncuestaModel {
  @Id
  @GeneratedValue
  @Column(name = "ENCUESTA_ID")
  private Long Id;

  @Column(name = "pregunta")
  @NotEmpty
  private String pregunta;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "ENCUESTA_ID")
  @OrderBy
  @Size(min = 2, max = 6)
  private Set<OpcionModel> opciones;

  public EncuestaModel() {
  }

  public EncuestaModel(Long Id, String pregunta, Set<OpcionModel> opciones) {
    this.Id = Id;
    this.pregunta = pregunta;
    this.opciones = opciones;
  }

  public Long getId() {
    return this.Id;
  }

  public void setId(Long Id) {
    this.Id = Id;
  }

  public String getPregunta() {
    return this.pregunta;
  }

  public void setPregunta(String pregunta) {
    this.pregunta = pregunta;
  }

  public Set<OpcionModel> getOpciones() {
    return this.opciones;
  }

  public void setOpciones(Set<OpcionModel> opciones) {
    this.opciones = opciones;
  }

}
