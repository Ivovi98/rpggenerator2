package com.rpggenerator2.controller;

import com.rpggenerator2.entity.Descrizione;
import com.rpggenerator2.service.DescrizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/descrizioni")
public class DescrizioneController {

    @Autowired
    private DescrizioneService descrizioneService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getDescrizioneById(@PathVariable Long id) {
        Optional<Descrizione> descrizione = descrizioneService.findById(id);
        return descrizione.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<?> createDescrizione(@RequestBody Descrizione descrizione) {
        Descrizione createdDescrizione = descrizioneService.insertDescrizione(descrizione);
        return new ResponseEntity<>(createdDescrizione, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDescrizione(@PathVariable Long id, @RequestBody Descrizione descrizione) {
        Optional<Descrizione> existingDescrizione = descrizioneService.findById(id);
        if (existingDescrizione.isPresent()) {
            Descrizione descrizioneToUpdate = existingDescrizione.get();
            descrizioneToUpdate.setDescrizione(descrizione.getDescrizione());
            descrizioneToUpdate.setDescrizione(descrizione.getDescrizione());
            descrizioneToUpdate.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
            Descrizione updatedDescrizione = descrizioneService.save(descrizioneToUpdate);
            return new ResponseEntity<>(updatedDescrizione, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDescrizione(@PathVariable Long id) {
        Optional<Descrizione> descrizioneToDelete = descrizioneService.findById(id);
        if (descrizioneToDelete.isPresent()) {
            descrizioneService.delete(descrizioneToDelete.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categoria")
    public ResponseEntity<?> getDescrizioneByCategoria(@RequestParam("categoria") String categoria) {
        Descrizione descrizione = descrizioneService.findByCategoriaDescrizione(categoria);
        return descrizione != null ? new ResponseEntity<>(descrizione, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*@GetMapping("/abilita")
    public ResponseEntity<?> getDescrizioniByNomeAttributiAbilita(@RequestParam("abilita") String abilita) {
        List<Descrizione> descrizioni = descrizioneService.findAllByNomeAttributiAbilitaContaining(abilita);
        return descrizioni != null && !descrizioni.isEmpty() ?
                new ResponseEntity<>(descrizioni, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/
}