package com.example.BackGestionNoticis.Controller;

import com.example.BackGestionNoticis.Model.Noticia;
import com.example.BackGestionNoticis.Service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/{id}")
    public Noticia obtenerNoticiaPorId(@PathVariable Long id) {
        return noticiaService.obtenerNoticiaPorId(id);
    }

    @GetMapping("/{id}/recomendadas")
    public List<Noticia> obtenerNoticiasRecomendadas(@PathVariable Long id) {
        return noticiaService.obtenerNoticiasRecomendadas(id);
    }
    @GetMapping("/all")
    public List<Noticia> obtenerTodasLasNoticias() {
        return noticiaService.obtenerTodasLasNoticias();
    }
}
