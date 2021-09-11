package io.github.bapadua.dsvendas.repositories;

import io.github.bapadua.dsvendas.model.dtos.SaleSuccessDTO;
import io.github.bapadua.dsvendas.model.dtos.SaleSumDTO;
import io.github.bapadua.dsvendas.model.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new io.github.bapadua.dsvendas.model.dtos.SaleSumDTO(sale.seller, SUM(sale.amount))" +
            "   FROM Sale AS sale GROUP BY sale.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new io.github.bapadua.dsvendas.model.dtos.SaleSuccessDTO(sale.seller, SUM(sale.visited), " +
            "SUM(sale.deals))" +
            "   FROM Sale AS sale GROUP BY sale.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
