package com.api.rest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.models.VotoModel;

@Repository
public interface VotoRepository extends CrudRepository<VotoModel, Long> {

  @Query(value = "select v.* from opcion o, voto v where o.ENCUESTA_ID = ?1 and v.OPCION_ID = o.OPCION_ID", nativeQuery = true)
  public Iterable<VotoModel> finfByEncuesta(Long id);
}
