package io.github.bapadua.dsvendas.controllers;

import io.github.bapadua.dsvendas.model.dtos.SellerDTO;
import io.github.bapadua.dsvendas.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sellers")
@RequiredArgsConstructor
public class SellersController {
    private final SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> list() {
        return ResponseEntity.ok(sellerService.findAll());
    }
}
