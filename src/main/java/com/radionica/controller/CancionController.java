package com.radionica.controller;

import com.radionica.model.Cancion;
import com.radionica.service.CancionService;

import java.util.Optional;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    private final CancionService cancionService;

    public CancionController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @GetMapping
    public List<Cancion> listarCanciones() {
        return cancionService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cancion> buscarCancion(@PathVariable Long id) {
        Optional<Cancion> cancion = cancionService.buscarPorId(id);
        return cancion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cancion crearCancion(@RequestBody Cancion cancion) {
        return cancionService.guardar(cancion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancion> actualizarCancion(@PathVariable Long id, @RequestBody Cancion cancion) {
        if (!cancionService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cancion.setId(id);
        return ResponseEntity.ok(cancionService.guardar(cancion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCancion(@PathVariable Long id) {
        if (!cancionService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cancionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}