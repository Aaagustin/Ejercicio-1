package com.restorant.platos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.restorant.platos.controller.PlatoController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlatoController.class)
class PlatosApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void debeCrearYConsultarUnPlato() throws Exception {
        String platoJson = """
                {
                  "numeroPlato": 1,
                  "nombre": "Milanesa con papas",
                  "precio": 12500.0,
                  "descripcion": "Milanesa de carne con papas fritas"
                }
                """;

        mockMvc.perform(post("/platos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(platoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numeroPlato").value(1))
                .andExpect(jsonPath("$.nombre").value("Milanesa con papas"));

        mockMvc.perform(get("/platos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroPlato").value(1));

        mockMvc.perform(get("/platos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descripcion").value("Milanesa de carne con papas fritas"));
    }

    @Test
    void debeResponderNotFoundSiElPlatoNoExiste() throws Exception {
        mockMvc.perform(get("/platos/99"))
                .andExpect(status().isNotFound());
    }

}
