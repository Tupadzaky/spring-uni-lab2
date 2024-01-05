package lab2.service;

import java.awt.PageAttributes;
import java.util.Objects;
import lab2.model.Grade;
import lab2.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;

    @Override
    @Transactional
    public Grade save(Grade grade) {
        return gradeRepository.saveAndFlush(grade);
    }

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade findById(Long id) {
        return gradeRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Grade update(Grade entity) {
        return gradeRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Page<Grade> findByMarkContaining(String mark, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return Objects.nonNull(mark) ? gradeRepository.findByMarkEquals(Integer.parseInt(mark), pageable)
                : gradeRepository.findAll(pageable);
    }

    @Override
    public Page<Grade> findAll(Pageable pageable) {
        return gradeRepository.findAll(pageable);
    }
}
