package com.example.BackGestionNoticis.Service;

import com.example.BackGestionNoticis.Model.Noticia;
import com.example.BackGestionNoticis.Repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia obtenerNoticiaPorId(Long id) {
        return noticiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
    }

    public List<Noticia> obtenerNoticiasRecomendadas(Long id) {

        Noticia noticiaActual = noticiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Noticia no encontrada"));

        String categoria = noticiaActual.getCategoria(); 


        if (categoria != null) {
            List<Noticia> recomendadas = noticiaRepository.findByCategoriaAndIdNot(categoria.toString(),id, PageRequest.of(0, 3));
            if (!recomendadas.isEmpty()) {
                return recomendadas;
            }
        }

    
        return noticiaRepository.findByIdNotOrderByFechaPublicacionDesc(id, PageRequest.of(0, 3));
    }

    public List<Noticia> obtenerTodasLasNoticias() {
        return noticiaRepository.findAll();
    }
}
