package com.radionica.repository;

import com.radionica.model.Cancion;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {
    List<Cancion> findByGeneroNombre(String nombreGenero);
}
