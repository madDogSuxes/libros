package com.example.libros;

import com.example.libros.modelos.Libro;
import com.example.libros.servicios.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@SpringBootApplication
public class LibrosApplication {
	@Autowired
	ServicioLibros servicioLibros;

	public static void main(String[] args) {
		SpringApplication.run(LibrosApplication.class, args);
	}

	CommandLineRunner leerLibro(){
		return args -> {
			BufferedReader br=new BufferedReader(new FileReader("libros.csv"));
			String linea= br.readLine();
			while (linea!=null){
				String[] registro=linea.split(";");

				Libro l=new Libro();
				l.setAutor(registro[0]);
				l.setTitulo(registro[1]);
				l.setFecha(LocalDate.now());
				servicioLibros.save(l);

				linea=br.readLine();

			}
		};
	}

}
