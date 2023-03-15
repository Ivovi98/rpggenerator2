package com.rpg.rpgGenerator.service;

import com.rpg.rpgGenerator.entity.Personaggio;
import com.rpg.rpgGenerator.repository.PersonaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class PersonaggioService {

    @Autowired
    private PersonaggioRepository personaggioRepository;

    public Personaggio findByNomePersonaggio(String nomePersonaggio) {
        return personaggioRepository.findByNomePersonaggio(nomePersonaggio);
    }

    /*public List<Personaggio> findAllByClassePersonaggio(String classePersonaggio) {
        return personaggioRepository.findAllByClassePersonaggio(classePersonaggio);
    }*/

    public Optional<Personaggio> findById(Long id) {
        return personaggioRepository.findById(id);
    }

    public Personaggio insertPersonaggio(Personaggio p) {
        return personaggioRepository.save(p);

    }

    public Personaggio save(Personaggio p) {
        return personaggioRepository.save(p);
    }

    public void delete(Personaggio p) {
        personaggioRepository.delete(p);
    }
}