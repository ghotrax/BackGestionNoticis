package com.example.BackGestionNoticis.Repository;

import com.example.BackGestionNoticis.Model.Noticia;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

   
    List<Noticia> findByCategoriaAndIdNot(String categoria,Long id, Pageable pageable);

    
    List<Noticia> findByIdNotOrderByFechaPublicacionDesc(Long id, Pageable pageable);
}
