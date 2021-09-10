package io.github.bapadua.dsvendas.model.adapters;

import io.github.bapadua.dsvendas.model.dtos.SaleDTO;
import io.github.bapadua.dsvendas.model.entities.Sale;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaleAdapter {

    private Sale sale;

    public static SaleDTO convert(final Sale sale) {
        return SaleDTO.builder()
                .id(sale.getId())
                .amount(sale.getAmount())
                .date(sale.getDate())
                .deals(sale.getDeals())
                .visited(sale.getVisited())
                .seller(SellerAdapter.convert(sale.getSeller()))
                .build();
    }
}
