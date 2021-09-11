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
public class SaleSumDTO implements Serializable {

    private String sellerName;
    private BigDecimal sum;

    public SaleSumDTO(Seller seller, BigDecimal sum) {
        this.sellerName = seller.getName();
        this.sum = sum;
    }
}
