package io.github.bapadua.dsvendas.controllers;

import io.github.bapadua.dsvendas.model.dtos.SaleDTO;
import io.github.bapadua.dsvendas.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> list(final Pageable pageable) {
        return ResponseEntity.ok(saleService.find(pageable));
    }
}
