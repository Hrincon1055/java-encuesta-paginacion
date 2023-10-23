package com.api.rest.controllers.v1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.dto.OpcionCountDTO;
import com.api.rest.dto.VotoResultDTO;
import com.api.rest.models.VotoModel;
import com.api.rest.repositories.VotoRepository;

@RestController
@RequestMapping("/api/encuesta/v1")
@Qualifier("v1")
public class ComputeResultController {
  @Autowired
  private VotoRepository votoRepository;

  @GetMapping("/calcularResultado")
  public ResponseEntity<?> calcularResultado(@RequestParam Long encuestaId) {
    VotoResultDTO votoResult = new VotoResultDTO();
    Iterable<VotoModel> votos = votoRepository.finfByEncuesta(encuestaId);

    // Algoritmo para contar votos
    int totalVotos = 0;
    Map<Long, OpcionCountDTO> tempMap = new HashMap<Long, OpcionCountDTO>();

    for (VotoModel v : votos) { // 1 - 2 - 3 - 4 -6
      totalVotos++;

      // Obtenemos la OpcionCount correspondiente a esta opcion
      OpcionCountDTO opcionCount = tempMap.get(v.getOpcion().getId());
      if (opcionCount == null) {
        opcionCount = new OpcionCountDTO();
        opcionCount.setOpcionId(v.getOpcion().getId());
        tempMap.put(v.getOpcion().getId(), opcionCount);
      }
      opcionCount.setCount(opcionCount.getCount() + 1);
    }

    votoResult.setTotalVotos(totalVotos);
    votoResult.setResult(tempMap.values());

    return new ResponseEntity<>(votoResult, HttpStatus.OK);
  }
}
