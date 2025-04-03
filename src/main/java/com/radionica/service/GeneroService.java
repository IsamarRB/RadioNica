package com.radionica.service;

@Service
public class GeneroService implements BaseService<Genero> {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public List<Genero> listarTodos() {
        return generoRepository.findAll();
    }

    @Override
    public Optional<Genero> buscarPorId(Long id) {
        return generoRepository.findById(id);
    }

    @Override
    public Genero guardar(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public void eliminar(Long id) {
        generoRepository.deleteById(id);
    }
}
