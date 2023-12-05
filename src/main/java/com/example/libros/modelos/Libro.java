package com.example.libros.modelos;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String resumen;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    private String autor;

    private String editorial;
}
