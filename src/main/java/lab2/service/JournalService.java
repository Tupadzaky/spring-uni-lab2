package lab2.service;

import java.util.List;

import lab2.model.Grade;
import lab2.model.Journal;
import lab2.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalService implements AbstractService<Journal> {

    private JournalRepository journalRepository;

    @Override
    public Journal save(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public List<Journal> findAll() {
        return journalRepository.findAll();
    }

    @Override
    public Journal findById(Long id) {
        return journalRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Autowired
    public void setJournalRepository(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }
}
