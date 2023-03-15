package  com.rpggenerator2.service;

import com.rpggenerator2.entity.Categoria;
import com.rpggenerator2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    /*
    public List<String> findAllNames() {
        return categoriaRepository.findAllNames();
    }
    */

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria insertCategoria(Categoria c) {
        return categoriaRepository.save(c);

    }

    public Categoria save(Categoria c) {
        return categoriaRepository.save(c);
    }

    public void delete(Categoria c) {
        categoriaRepository.delete(c);
    }
}