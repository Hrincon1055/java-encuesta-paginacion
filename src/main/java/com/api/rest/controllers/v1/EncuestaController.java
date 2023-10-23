package com.api.rest.controllers.v1;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.api.rest.exception.ResourceNotFoundException;
import com.api.rest.models.EncuestaModel;
import com.api.rest.repositories.EncuestaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/encuesta/v1")
public class EncuestaController {
  @Autowired
  private EncuestaRepository encuestaRepository;

  @GetMapping
  public ResponseEntity<Iterable<EncuestaModel>> list(Pageable pageable) {
    Page<EncuestaModel> encuestas = this.encuestaRepository.findAll(pageable);
    return new ResponseEntity<Iterable<EncuestaModel>>(encuestas, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<EncuestaModel> save(@Valid @RequestBody EncuestaModel encuesta) {
    encuesta = encuestaRepository.save(encuesta);
    HttpHeaders httpHeaders = new HttpHeaders();
    URI newEncuestaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(encuesta.getId())
        .toUri();
    httpHeaders.setLocation(newEncuestaUri);
    return new ResponseEntity<EncuestaModel>(httpHeaders, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EncuestaModel> get(@PathVariable("id") Long id) {
    this.verifyEncuesta(id);
    try {
      EncuestaModel encuesta = this.encuestaRepository.findById(id).orElse(null);
      if (encuesta != null) {
        return new ResponseEntity<EncuestaModel>(encuesta, HttpStatus.OK);
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<EncuestaModel> update(@Valid @RequestBody EncuestaModel encuesta, @PathVariable("id") Long id) {
    this.verifyEncuesta(id);
    try {
      encuesta.setId(id);
      encuestaRepository.save(encuesta);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    this.verifyEncuesta(id);
    this.encuestaRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  protected void verifyEncuesta(Long id) {
    Optional<EncuestaModel> encuesta = encuestaRepository.findById(id);
    if (!encuesta.isPresent()) {
      throw new ResourceNotFoundException("Encuesta con el ID: " + id + " no encontrada");
    }
  }
}
