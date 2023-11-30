package lab2.service;

import lab2.model.Grade;
import lab2.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class GradeService implements AbstractService<Grade> {
    private final GradeRepository gradeRepository;

    @Override
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
}
