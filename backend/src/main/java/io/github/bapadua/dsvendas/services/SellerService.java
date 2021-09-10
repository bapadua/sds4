package io.github.bapadua.dsvendas.services;

import io.github.bapadua.dsvendas.model.dtos.SellerDTO;
import io.github.bapadua.dsvendas.repositories.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.github.bapadua.dsvendas.model.adapters.SellerAdapter.convert;

@Service("SellerService")
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public List<SellerDTO> findAll() {
        return convert(sellerRepository.findAll());
    }
}
