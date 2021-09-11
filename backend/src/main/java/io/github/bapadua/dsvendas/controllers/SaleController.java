package io.github.bapadua.dsvendas.controllers;

import io.github.bapadua.dsvendas.model.dtos.SaleDTO;
import io.github.bapadua.dsvendas.model.dtos.SaleSuccessDTO;
import io.github.bapadua.dsvendas.model.dtos.SaleSumDTO;
import io.github.bapadua.dsvendas.services.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> list(final Pageable pageable) {
        log.info("chamada lista de vendas");
        return ResponseEntity.ok(saleService.find(pageable));
    }

    @GetMapping("/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountBySeller() {
        log.info("chamada total de vendas por vendedor");
        return ResponseEntity.ok(saleService.amountBySeller());
    }

    @GetMapping("/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successBySeller() {
        log.info("chamada indice sucesso por vendedor");
        return ResponseEntity.ok(saleService.successBySeller());
    }
}
