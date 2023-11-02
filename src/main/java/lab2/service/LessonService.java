package lab2.service;

import java.util.List;
import java.util.Optional;
import lab2.model.Lesson;
import lab2.repository.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonService implements AbstractService<Lesson> {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }
}
