package io.github.bapadua.dsvendas.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO implements Serializable {

    private Long id;
    private Integer visited;
    private Integer deals;
    private BigDecimal amount;
    private LocalDate date;

    private SellerDTO seller;

}
