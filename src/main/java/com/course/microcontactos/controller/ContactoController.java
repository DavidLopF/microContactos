package com.course.microcontactos.controller;


import com.course.microcontactos.dto.ContactoRequestDTO;
import com.course.microcontactos.dto.GeneralResponseDTO;
import com.course.microcontactos.services.ContactoServiceImp;
import com.course.microcontactos.util.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@Log4j2
public class ContactoController {

    @Autowired
    private ContactoServiceImp contactoService;

    @PostMapping(value = "/createContacto", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<GeneralResponseDTO> createContacto(@Valid @RequestBody ContactoRequestDTO request, BindingResult results) {
        log.info("Lanzando servicio Post - Crear contacto");
        GeneralResponseDTO response = new GeneralResponseDTO();
        if (results.hasErrors()) {
            log.error("Error en el request: " + results);
            response.setMensaje("Error en el request: " + Util.getJson(Util.fieldsValidator(results)));
            return ResponseEntity.badRequest().body(response);
        }


        boolean created = contactoService.agregarContacto(request);

        if (created) {
            response.setMensaje("Contacto creado correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.setMensaje("Error al crear el contacto");
            return ResponseEntity.badRequest().body(response);
        }

    }


}
