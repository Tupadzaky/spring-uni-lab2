package lab2.config;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import lab2.model.Grade;
import lab2.model.Journal;
import lab2.model.Lesson;
import lab2.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializationBean {
    private final AbstractService<Grade> gradeService;
    private final AbstractService<Lesson> lessonService;
    private final AbstractService<Journal> journalService;

    @PostConstruct
    public void init() {
        Grade grade = new Grade().setMark(5);
        gradeService.save(grade);
        Lesson lesson = new Lesson().setName("Jaba").setGrade(grade);
        lessonService.save(lesson);
        Journal journal = new Journal().setStudentName("Student").setLessons(List.of(lesson));
        journalService.save(journal);
    }
}
