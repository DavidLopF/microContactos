package com.course.microcontactos.services;

import com.course.microcontactos.dto.ContactoRequestDTO;
import com.course.microcontactos.entities.Contacto;

import java.util.List;

public interface ContactoService {

    Contacto agregarContacto(ContactoRequestDTO contacto);

    Contacto recuperarContacto(String email);

    void eliminarContacto(String email);

    List<Contacto> devolverContactos();

    Contacto devolverContacto(int idContacto);

    void actualizarContacto(Contacto contactoDTO);

}
