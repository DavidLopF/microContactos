package com.course.microcontactos.services;

import com.course.microcontactos.dto.ContactoRequestDTO;
import com.course.microcontactos.entities.Contacto;

import java.util.List;

public interface ContactoService {

    boolean agregarContacto(ContactoRequestDTO contacto);

    void recuperarContacto(String email);

    void eliminarContacto(String email);

    List<ContactoRequestDTO> devolverContactos();

    void eliminarContacto(int idContacto);

    Contacto devolverContacto(int idContacto);

    void actualizarContacto(Contacto contactoDTO);

}
