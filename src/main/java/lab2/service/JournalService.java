package lab2.service;

import java.util.List;
import java.util.Optional;
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
    public Optional<Journal> findById(Long id) {
        return journalRepository.findById(id);
    }

    @Autowired
    public void setJournalRepository(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }
}
