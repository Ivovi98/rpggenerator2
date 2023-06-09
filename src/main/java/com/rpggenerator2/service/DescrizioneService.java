package  com.rpggenerator2.service;

import com.rpggenerator2.entity.Descrizione;
import com.rpggenerator2.repository.DescrizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DescrizioneService {

    @Autowired
    private DescrizioneRepository descrizioneRepository;

    public Optional<Descrizione> findById(Long id) {
        return descrizioneRepository.findByAbilitaId(id);
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