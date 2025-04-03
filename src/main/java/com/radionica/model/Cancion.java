package com.radionica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "cantante_id")
    private Cantante cantante;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    public Cancion() {}

    public Cancion(String titulo, Cantante cantante, Genero genero) {
        this.titulo = titulo;
        this.cantante = cantante;
        this.genero = genero;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Cantante getCantante() { return cantante; }
    public void setCantante(Cantante cantante) { this.cantante = cantante; }
    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }
}