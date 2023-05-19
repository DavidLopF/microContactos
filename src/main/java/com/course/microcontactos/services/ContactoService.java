package com.course.microcontactos.services;

import com.course.microcontactos.dto.ContactoRequestDTO;
import com.course.microcontactos.entities.Contacto;

import java.util.List;

public interface ContactoService {

    Contacto agregarContacto(ContactoRequestDTO contacto);

    Contacto recuperarContacto(String email);

    boolean eliminarContacto(String email);

    List<Contacto> devolverContactos();



}
