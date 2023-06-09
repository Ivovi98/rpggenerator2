package com.rpggenerator2.service;

import com.rpggenerator2.entity.Abilita;
import com.rpggenerator2.repository.AbilitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AbilitaService {

    @Autowired
    private AbilitaRepository abilitaRepository;

    public Optional<Abilita> findById(Long id) {
        return abilitaRepository.findById(id);
    }

    public Abilita save(Abilita a) {
        return abilitaRepository.save(a);
    }

    public void delete(Abilita a) {
        abilitaRepository.delete(a);
    }

        /*
    public List<Abilita> findAllByNomeAttributiAbilitaContaining(String nomeAttributiAbilita) {
        return abilitaRepository.findAllByNomeAttributiAbilitaContaining(nomeAttributiAbilita);
    }

    public Abilita findByNomeAbilita(String nomeAbilita) {
        return abilitaRepository.findByNomeAbilita(nomeAbilita);
    }
    */
}