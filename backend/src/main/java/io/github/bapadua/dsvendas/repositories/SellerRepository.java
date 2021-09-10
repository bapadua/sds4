package io.github.bapadua.dsvendas.repositories;

import io.github.bapadua.dsvendas.model.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
