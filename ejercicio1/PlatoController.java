package com.practico.ejercicio1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    private List<Plato> platos = new ArrayList<>();

    @PostMapping
    public Plato crearPlato(@RequestBody Plato plato) {
        platos.add(plato);
        return plato;
    }

    @GetMapping
    public List<Plato> listarPlatos() {
        return platos;
    }

    @GetMapping("/{numero}")
    public Plato obtenerPlatoPorNumero(@PathVariable int numero) {
        for (Plato plato : platos) {
            if (plato.getNumero() == numero) {
                return plato;
            }
        }return null;
    }
}
