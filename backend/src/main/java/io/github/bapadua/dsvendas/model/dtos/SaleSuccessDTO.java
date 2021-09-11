package io.github.bapadua.dsvendas.model.dtos;

import io.github.bapadua.dsvendas.model.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleSuccessDTO implements Serializable {

    private String sellerName;
    private Long visited;
    private Long deals;

    public SaleSuccessDTO(Seller seller, Long visited, Long deals) {
        sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
