package com.wiss.m223.service;

import com.wiss.m223.model.Notizen;
import com.wiss.m223.repository.NotizenRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NotizenService<NotizDTO> {
    private final NotizenRepository notizenRepository;

    public NotizenService(NotizenRepository notizenRepository) {
        this.notizenRepository = notizenRepository;
    }
    public void createNotiz(NotizDTO notizDTO) {
        Notizen notiz = new Notizen();
        notiz.setTitel(notiz.getTitel());
        notiz.setInhalt(notiz.getInhalt());
        notiz.setErstellungsdatum(new Date());

        notizenRepository.save(notiz);
    }

    public void deleteNotiz(Long notizId) {
        Optional<Notizen> optionalNotiz = notizenRepository.findById(notizId);
        if (optionalNotiz.isPresent()) {
            Notizen notiz = optionalNotiz.get();
            notizenRepository.delete(notiz);
        } else {
            throw new NoSuchElementException("Notiz mit der ID " + notizId + " wurde nicht gefunden.");
        }
    }
}
