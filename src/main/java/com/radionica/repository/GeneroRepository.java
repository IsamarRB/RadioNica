package com.radionica.repository;

import com.radionica.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Genero findByNombre(String nombre);
}