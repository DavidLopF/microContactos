package com.course.microcontactos.services;

import com.course.microcontactos.dto.ContactoRequestDTO;
import com.course.microcontactos.entities.Contacto;
import com.course.microcontactos.repositories.ContactoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ContactoServiceImp implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public Contacto agregarContacto(ContactoRequestDTO contactoDTO) {
        try {
            Contacto contacto = new Contacto();
            contacto.setNombre(contactoDTO.getName());
            contacto.setEdad(contactoDTO.getEdad());
            contacto.setEmail(contactoDTO.getEmail());
            contacto = contactoRepository.save(contacto);
            log.info("Contacto agregado correctamente");
            return contacto;
        } catch (Exception e) {
            log.error("Error in agregarContacto", e);
            return null;
        }
    }

    @Override
    public Contacto recuperarContacto(String email) {
       return contactoRepository.findByEmail(email);
    }

    @Override
    public boolean eliminarContacto(String email) {
        try{
        contactoRepository.deleteByEmail(email);
        return true;
        }catch (Exception e){
            log.error("Error in eliminarContacto", e);
            return false;
        }
    }

    @Override
    public List<Contacto> devolverContactos() {
        List<Contacto> list = contactoRepository.findALL();
        return list;
    }

}
