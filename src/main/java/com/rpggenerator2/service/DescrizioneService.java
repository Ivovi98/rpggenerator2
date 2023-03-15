package  com.rpggenerator2.service;

import com.rpg.rpgGenerator.entity.Descrizione;
import com.rpg.rpgGenerator.repository.DescrizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescrizioneService {

    @Autowired
    private DescrizioneRepository descrizioneRepository;

    public Descrizione findByCategoriaDescrizione(String categoriaDescrizione) {
        return descrizioneRepository.findByCategoriaDescrizione(categoriaDescrizione);
    }

    /*public List<Descrizione> findAllByNomeAttributiAbilitaContaining(String nomeAttributiAbilita) {
        return descrizioneRepository.findAllByNomeAttributiAbilitaContaining(nomeAttributiAbilita);
    }*/

    public Optional<Descrizione> findById(String id) {
        return descrizioneRepository.findById(id);
    }

    public Descrizione insertDescrizione(Descrizione d) {
        return descrizioneRepository.save(d);

    }

    public Descrizione save(Descrizione d) {
        return descrizioneRepository.save(d);
    }

    public void delete(Descrizione d) {
        descrizioneRepository.delete(d);
    }
}