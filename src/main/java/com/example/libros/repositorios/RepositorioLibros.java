package com.example.libros.repositorios;

import com.example.libros.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioLibros extends JpaRepository<Libro, Long> {
    public List<Libro> findAll();
    public Libro findById(long id);
    public Libro save(Libro l);
    public void deleteById(long id);
}
