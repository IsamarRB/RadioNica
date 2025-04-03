package com.radionica.service;

@Service
public class CantanteService implements BaseService<Cantante> {

    private final CantanteRepository cantanteRepository;

    public CantanteService(CantanteRepository cantanteRepository) {
        this.cantanteRepository = cantanteRepository;
    }

    @Override
    public List<Cantante> listarTodos() {
        return cantanteRepository.findAll();
    }

    @Override
    public Optional<Cantante> buscarPorId(Long id) {
        return cantanteRepository.findById(id);
    }

    @Override
    public Cantante guardar(Cantante cantante) {
        return cantanteRepository.save(cantante);
    }

    @Override
    public void eliminar(Long id) {
        cantanteRepository.deleteById(id);
    }
}
