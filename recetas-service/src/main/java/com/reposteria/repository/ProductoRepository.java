package com.reposteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reposteria.common.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
