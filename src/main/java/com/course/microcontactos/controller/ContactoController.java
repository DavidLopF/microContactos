package com.course.microcontactos.controller;


import com.course.microcontactos.dto.ContactoRequestDTO;
import com.course.microcontactos.dto.GeneralResponseDTO;
import com.course.microcontactos.entities.Contacto;
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
        Contacto contacto = contactoService.agregarContacto(request);
        if (contacto == null) {
            response.setMensaje("Error al crear el contacto o contacto repetido");
            response.setObject(null);
            return ResponseEntity.badRequest().body(response);
        } else {
            response.setMensaje("Contacto creado correctamente");
            response.setObject(contacto);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping(value = "/getContacto", produces = "application/json")
    public ResponseEntity<GeneralResponseDTO> getContactoByEmail(@RequestParam String email){
        log.info("Lanzando servicio Get - Recuperar contacto el email es : " + email );
        GeneralResponseDTO response = new GeneralResponseDTO();
        Contacto contacto = contactoService.recuperarContacto(email);
        if (contacto == null) {
            response.setMensaje("Error al recuperar el contacto");
            response.setObject(null);
            return ResponseEntity.badRequest().body(response);
        } else {
            response.setMensaje("Contacto recuperado correctamente");
            response.setObject(contacto);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping(value = "/getAllContacto", produces = "application/json")
    public ResponseEntity<GeneralResponseDTO> getAllContacto(){
        log.info("Lanzando servicio Get - Recuperar todos los contactos");
        GeneralResponseDTO response = new GeneralResponseDTO();
        response.setMensaje("Contactos recuperados correctamente");
        response.setObject(contactoService.devolverContactos());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/deleteContacto", produces = "application/json")
    public ResponseEntity<GeneralResponseDTO> deleteContacto(@RequestParam String email){
        log.info("Lanzando servicio Delete - Eliminar contacto el email es : " + email );
        GeneralResponseDTO response = new GeneralResponseDTO();
        boolean flag = contactoService.eliminarContacto(email);
        if(flag) {
            response.setMensaje("Contacto eliminado correctamente");
            response.setObject(null);
            return ResponseEntity.ok(response);
        } else {
            response.setMensaje("Error al eliminar el contacto");
            response.setObject(null);
            return ResponseEntity.badRequest().body(response);
        }
    }


}
