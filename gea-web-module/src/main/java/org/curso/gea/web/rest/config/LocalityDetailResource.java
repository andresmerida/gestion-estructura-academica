package org.curso.gea.web.rest.config;

import org.curso.gea.domain.config.pojo.LocalityDetail;
import org.curso.gea.service.config.LocalityDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/config/reports/localities")
public class LocalityDetailResource {

    private final LocalityDetailService localityDetailService;

    public LocalityDetailResource(LocalityDetailService localityDetailService) {
        this.localityDetailService = localityDetailService;
    }

    @GetMapping
    public ResponseEntity<List<LocalityDetail>> getAllLocalitiesDetail() {
        return ResponseEntity.ok().body(localityDetailService.getAllLocalitiesDetail());
    }
}
