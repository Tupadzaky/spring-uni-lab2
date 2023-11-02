package lab2.service;

import java.util.List;

import lab2.model.Grade;
import lab2.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService implements AbstractService<Grade> {
    @Autowired
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
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
}
