package io.github.bapadua.dsvendas.model.adapters;

import io.github.bapadua.dsvendas.model.dtos.SellerDTO;
import io.github.bapadua.dsvendas.model.entities.Seller;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SellerAdapter {

    private Seller seller;

    public static SellerDTO convert(final Seller seller) {
        return SellerDTO
                .builder()
                .id(seller.getId())
                .name(seller.getName())
                .build();
    }

    public static List<SellerDTO> convert(final List<Seller> list) {
        return list.stream()
                .map(SellerAdapter::convert)
                .collect(Collectors.toList());
    }
}
