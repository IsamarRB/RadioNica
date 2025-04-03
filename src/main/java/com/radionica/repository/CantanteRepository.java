package com.radionica.repository;

import com.radionica.model.Cantante;

@Repository
public interface CantanteRepository extends JpaRepository<Cantante, Long> {
    Cantante findByNombre(String nombre);
}
