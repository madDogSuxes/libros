package com.example.libros.controladores;

import com.example.libros.modelos.Libro;
import com.example.libros.servicios.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/crud")
public class Crud {
    @Autowired
    ServicioLibros servicioLibros;

    @GetMapping("/libros")
    public String listarLibros(Model model){
        model.addAttribute("listaLibros", servicioLibros.findAll());
        return "crud";
    }

    @GetMapping("/libros/add")
    public String addLibro(Model model){
        model.addAttribute("libro", new Libro());
        return "formulario";
    }

    @PostMapping("/libros/postadd")
    public String postAddLibros(@ModelAttribute("libro") Libro nuevoLibro){
        servicioLibros.save(nuevoLibro);
        return "redirect:/crud/libros/add";
    }

    @GetMapping("/libros/update/{id}")
    public String updateLibros(Model model, @PathVariable long id){
        Libro libro=servicioLibros.findById(id);
        model.addAttribute("libro", libro);
        return "formulario";
    }

    @PostMapping("/libros/postupdate")
    public String postUpdateLibros(@ModelAttribute("libro") Libro libro){
        servicioLibros.save(libro);
        return "redirect:/crud/libros";
    }

    @GetMapping("/libros/delete/{id}")
    public String deleteLibros(@PathVariable long id, Model model){
        servicioLibros.deleteById(id);
        return "redirect:/crud/libros";
    }
}
