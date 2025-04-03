package com.radionica.service;

@Service
public class PodcastService implements BaseService<Podcast> {

    private final PodcastRepository podcastRepository;

    public PodcastService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    @Override
    public List<Podcast> listarTodos() {
        return podcastRepository.findAll();
    }

    @Override
    public Optional<Podcast> buscarPorId(Long id) {
        return podcastRepository.findById(id);
    }

    @Override
    public Podcast guardar(Podcast podcast) {
        return podcastRepository.save(podcast);
    }

    @Override
    public void eliminar(Long id) {
        podcastRepository.deleteById(id);
    }
}