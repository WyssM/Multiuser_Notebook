package com.wiss.m223.service;

import com.wiss.m223.model.Kategorien;
import com.wiss.m223.repository.KategorienRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class KategorienService<KategorieDTO> {
    private final KategorienRepository kategorienRepository;

    public KategorienService(KategorienRepository kategorienRepository) {
        this.kategorienRepository = kategorienRepository;
    }

    public void createKategorie(KategorieDTO kategorieDTO) {
        Kategorien kategorie = new Kategorien();
        kategorie.setName(kategorie.getName());
        kategorie.setBeschreibung(kategorie.getBeschreibung());
        kategorienRepository.save(kategorie);
    }

    public void deleteKategorie(Long kategorieId) {
        Optional<Kategorien> optionalKategorie = kategorienRepository.findById(kategorieId);
        if (optionalKategorie.isPresent()) {
            Kategorien kategorie = optionalKategorie.get();
            kategorienRepository.delete(kategorie);
        } else {
            throw new NoSuchElementException("Kategorie mit der ID " + kategorieId + " wurde nicht gefunden.");
        }
    }
}
