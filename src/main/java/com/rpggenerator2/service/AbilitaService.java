package com.rpggenerator2.service;

import com.rpggenerator2.entity.Abilita;
import com.rpggenerator2.repository.AbilitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AbilitaService {

    @Autowired
    private AbilitaRepository abilitaRepository;

    public List<Abilita> findAll() {
        return abilitaRepository.findAll();
    }

    public List<Abilita> findAllByNomeAttributiAbilitaContaining(String nomeAttributiAbilita) {
        return abilitaRepository.findAllByNomeAttributiAbilitaContaining(nomeAttributiAbilita);
    }

    public Abilita findByNomeAbilita(String nomeAbilita) {
        return abilitaRepository.findByNomeAbilita(nomeAbilita);
    }

    public Abilita insertAbilita(Abilita a) {
        return abilitaRepository.save(a);

    }

    public Abilita save(Abilita a) {
        return abilitaRepository.save(a);
    }

    public void delete(Abilita a) {
        abilitaRepository.delete(a);
    }
}