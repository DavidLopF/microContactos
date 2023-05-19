package com.course.microcontactos.repositories;

import com.course.microcontactos.entities.Contacto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    Contacto save(Contacto contacto);

    Contacto findByEmail(String email);

    @Transactional
    @Modifying
    @Query("delete from Contacto c where c.email = ?1")
    void deleteByEmail(String email);

    List<Contacto> findALL();

    Contacto findContactoByIdContacto(int idContacto);


}
