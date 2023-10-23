package com.api.rest.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.rest.models.VotoModel;
import com.api.rest.repositories.VotoRepository;

@RestController
@RequestMapping("/api/encuesta/v1")
public class VotoController {
  @Autowired
  private VotoRepository votoRepository;

  @PostMapping("/{id}/votos")
  public ResponseEntity<?> save(@PathVariable("id") Long id, @RequestBody VotoModel voto) {
    voto = votoRepository.save(voto);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setLocation(
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(voto.getId()).toUri());
    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
  }

  @GetMapping("/{id}/votos")
  public Iterable<VotoModel> listAllVotes(@PathVariable("id") Long id) {
    return votoRepository.finfByEncuesta(id);
  }
}
