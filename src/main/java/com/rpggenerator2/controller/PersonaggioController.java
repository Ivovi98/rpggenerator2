package com.rpggenerator2.controller;

import com.rpggenerator2.entity.Personaggio;
import com.rpggenerator2.service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping("/personaggio")
public class PersonaggioController {

    @Autowired
    private PersonaggioService personaggioService;

    @GetMapping("/{id}") //READ GET BY ID
    public ResponseEntity<Personaggio> getPersonaggioById(@PathVariable Long id){
        Optional<Personaggio> existingPersonaggio = personaggioService.findById(id);
        try {
            if(existingPersonaggio.isPresent()){
                return new ResponseEntity<>(existingPersonaggio.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    @PostMapping //provare magari con param anziché request body per classe
    public ResponseEntity<Personaggio> createrPersonaggio(@RequestBody Personaggio personaggio, Classe classe) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        personaggio.setDataCreazione(timestamp);
        //personaggiolsetClasse(classe);
        personaggioService.save(personaggio);
        return new ResponseEntity<>(personaggio, HttpStatus.CREATED);
    }
    */
    @PostMapping
    public ResponseEntity<Personaggio> createPersonaggio(@RequestBody Personaggio personaggio) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        personaggio.setDataCreazione(timestamp);
        personaggioService.save(personaggio);
        return new ResponseEntity<>(personaggio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personaggio> updatePersonaggio(@PathVariable Long id, @RequestBody Personaggio personaggio) {
        Optional<Personaggio> existingPersonaggio = personaggioService.findById(id);

        if (!existingPersonaggio.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        } else {
            Personaggio personaggioDiAppoggio = existingPersonaggio.get();
            personaggioDiAppoggio.setForza(personaggio.getForza());
            personaggioDiAppoggio.setIntellij(personaggio.getIntellij());
            personaggioDiAppoggio.setLivello(personaggio.getLivello());
            personaggioDiAppoggio.setNome(personaggio.getNome());
            personaggioDiAppoggio.setSalute(personaggio.getSalute());
            personaggioDiAppoggio.setClasse(personaggio.getClasse());
            personaggioDiAppoggio.setVersione(personaggio.getVersione());
            personaggioDiAppoggio.setDataUltimaModifica(personaggio.getDataUltimaModifica());
            Personaggio personaggioAggiornato = personaggioService.save(personaggioDiAppoggio);
            return new ResponseEntity<>(personaggioAggiornato, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonaggio(@PathVariable Personaggio p) {
        Optional<Personaggio> personaggio = personaggioService.findById(p.getId());
        if (!personaggio.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personaggioService.delete(p);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
    /*

    @PostMapping //CREATE
    public ResponseEntity<Personaggio> insertPersonaggioPersonaggio(@RequestBody Personaggio personaggio){
        try {
            Personaggio p = personaggioService.insertPersonaggio(personaggio);
            if(p == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
            }
            return new ResponseEntity<>(p, HttpStatus.CREATED); //201
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }


    @PutMapping("/{id}/{nome}") //EDIT
    public ResponseEntity<Personaggio> updatePersonaggio(@PathVariable Long id,
                                                       @PathVariable String nomePersonaggio){
        Optional<Personaggio> existingPersonaggio = personaggioService.findById(id);
        try {
            if(existingPersonaggio.isPresent()){
                Personaggio personaggio = existingPersonaggio.get();
                personaggio.setNome(nomePersonaggio);
                personaggio.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
                personaggio.setVersione(personaggio.getVersione() + 1);
                Personaggio updatedPersonaggio = personaggioService.save(personaggio);
                return new ResponseEntity<>(updatedPersonaggio, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}") //DELETE
    public ResponseEntity<Void> deletePersonaggio(@PathVariable Long id){
        Optional<Personaggio> existingPersonaggio = personaggioService.findById(id);
        try {
            if(existingPersonaggio.isPresent()){
                personaggioService.delete(existingPersonaggio.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
