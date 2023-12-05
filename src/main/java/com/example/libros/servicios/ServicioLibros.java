package com.example.libros.servicios;

import com.example.libros.modelos.Libro;
import com.example.libros.repositorios.RepositorioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioLibros {
    @Autowired
    RepositorioLibros repositorioLibros;

    public List<Libro> findAll(){
        return repositorioLibros.findAll();
    }
    public Libro findById(long id){
        return repositorioLibros.findById(id);
    }
    public Libro save(Libro libro){
        return repositorioLibros.save(libro);
    }

    public void deleteById(long id){
        repositorioLibros.deleteById(id);
    }
}
