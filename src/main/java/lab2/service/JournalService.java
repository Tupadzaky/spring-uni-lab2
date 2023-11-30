package lab2.service;

import lab2.model.Journal;
import lab2.repository.JournalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalService implements AbstractService<Journal> {

    private final JournalRepository journalRepository;

    @Override
    public Journal save(Journal journal) {
        return journalRepository.saveAndFlush(journal);
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

    @Override
    public Journal update(Journal entity) {
        return journalRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(Long id) {
        journalRepository.deleteById(id);
    }
}
