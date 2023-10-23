package com.api.rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.models.OpcionModel;

@Repository
public interface OpcionRepository extends CrudRepository<OpcionModel, Long> {

}
