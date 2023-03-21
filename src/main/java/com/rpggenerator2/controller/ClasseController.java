package com.rpggenerator2.controller;

import com.rpggenerator2.entity.Classe;
import com.rpggenerator2.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/classe")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping("/{id}") //READ GET BY ID
    public ResponseEntity<Classe> getClasseById(@PathVariable Long id){
        Optional<Classe> existingClasse = classeService.findById(id);
        try {
            if(existingClasse.isPresent()){
                return new ResponseEntity<>(existingClasse.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<?> addClasse(@RequestBody Classe classe) {
        Classe createdClasse = classeService.insertClasse(classe);
        return new ResponseEntity<>(createdClasse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classe> updateClasse(@PathVariable Long id, @RequestBody Classe classe) {
        Optional<Classe> existingClasse = classeService.findById(id);

        if (!existingClasse.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        } else {
            Classe classeDiAppoggio = existingClasse.get();
            classeDiAppoggio.setNomeAttributiClasse(classe.getNomeAttributiClasse());
            classeDiAppoggio.setVersione(classe.getVersione());
            classeDiAppoggio.setDataUltimaModifica(classe.getDataUltimaModifica());
            Classe classeAggiornata = classeService.save(classeDiAppoggio);
            return new ResponseEntity<>(classeAggiornata, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClasse(@PathVariable Long id) {
        Optional<Classe> existingClasse = classeService.findById(id);
        if (existingClasse.isPresent()) {
            classeService.delete(existingClasse.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /*
    @GetMapping("/search")
    public ResponseEntity<?> searchClasse(@RequestParam String nomeClasse) {
        Classe classe = classeService.findByNomeClasse(nomeClasse);
        if (classe != null) {
            return new ResponseEntity<>(classe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    METODO GET GENERALE
    @GetMapping("/{id}")
    public ResponseEntity<?> getClasse(@PathVariable String id) {
        Optional<Classe> classe = classeService.findById(id);
        if (classe.isPresent()) {
            return new ResponseEntity<>(classe.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     */
}