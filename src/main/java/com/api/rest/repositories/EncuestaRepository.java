package com.api.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.api.rest.models.EncuestaModel;

@Repository
public interface EncuestaRepository extends JpaRepository<EncuestaModel, Long> {

}
