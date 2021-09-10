package io.github.bapadua.dsvendas.services;

import io.github.bapadua.dsvendas.model.adapters.SaleAdapter;
import io.github.bapadua.dsvendas.model.dtos.SaleDTO;
import io.github.bapadua.dsvendas.repositories.SaleRepository;
import io.github.bapadua.dsvendas.repositories.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("SaleService")
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;


    @Transactional(readOnly = true)
    public Page<SaleDTO> find(Pageable pageable) {
        sellerRepository.findAll();
        return saleRepository.findAll(pageable)
                .map(SaleAdapter::convert);
    }
}
