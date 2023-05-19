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
public class ContactoServiceImp implements ContactoService{

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public  boolean agregarContacto(ContactoRequestDTO contactoDTO) {
        try {
        Contacto contacto = new Contacto();
        contacto.setNombre(contactoDTO.getName());
        contacto.setEdad(contactoDTO.getEdad());
        contacto.setEmail(contactoDTO.getEmail());
        contactoRepository.save(contacto);
        log.info("Contacto agregado correctamente");
        return true;
        }catch(Exception e){
            log.error("Error in agregarContacto", e);
            return false;
        }
    }

    @Override
    public void recuperarContacto(String email) {
        contactoRepository.findByEmail(email);
    }

    @Override
    public void eliminarContacto(String email) {
        contactoRepository.deleteByEmail(email);
    }

    @Override
    public List<ContactoRequestDTO> devolverContactos() {
        //List<ContactoDTO> list =  ContactoRepository.findAll();

        return null;
    }

    @Override
    public void eliminarContacto(int idContacto) {
        contactoRepository.deleteById(idContacto);
    }

    @Override
    public Contacto devolverContacto(int idContacto) {
        contactoRepository.findContactoByIdContacto(idContacto);
        return null;
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }
}
