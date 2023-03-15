package com.rpggenerator2.service;

import com.rpggenerator2.entity.Classe;
import com.rpggenerator2.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    /*
    public Classe findByNomeClasse(String nomeClasse) {
        return classeRepository.findByNomeClasse(nomeClasse);
    }
    */

    public Optional<Classe> findById(Long id) {
        return classeRepository.findById(id);
    }

    public Classe insertClasse(Classe c) {
        return classeRepository.save(c);

    }

    public Classe save(Classe c) {
        return classeRepository.save(c);
    }

    public void delete(Classe c) {
        classeRepository.delete(c);
    }
}