package io.github.bapadua.dsvendas.repositories;

import io.github.bapadua.dsvendas.model.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
