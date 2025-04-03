package com.radionica.repository;

import com.radionica.model.Podcast;

@Repository
public interface PodcastRepository extends JpaRepository<Podcast, Long> {
    List<Podcast> findByGeneroNombre(String nombreGenero);
}
