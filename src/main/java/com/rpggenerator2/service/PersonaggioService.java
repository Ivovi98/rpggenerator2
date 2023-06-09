package  com.rpggenerator2.service;

import com.rpggenerator2.entity.Personaggio;
import com.rpggenerator2.repository.PersonaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PersonaggioService {

    @Autowired
    private PersonaggioRepository personaggioRepository;

    /*
    public Personaggio findByNomePersonaggio(String nomePersonaggio) {
        return personaggioRepository.findByNomePersonaggio(nomePersonaggio);
    }

    public List<Personaggio> findAllByClassePersonaggio(String classePersonaggio) {
        return personaggioRepository.findAllByClassePersonaggio(classePersonaggio);
    }
    */

    public Optional<Personaggio> findById(Long id) {
        return personaggioRepository.findById(id);
    }

    public Personaggio save(Personaggio p) {
        return personaggioRepository.save(p);
    }

    public void delete(Personaggio p) {
        personaggioRepository.delete(p);
    }
}