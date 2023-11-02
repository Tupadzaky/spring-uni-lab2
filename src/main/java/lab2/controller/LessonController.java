package lab2.controller;

import java.util.List;
import java.util.stream.Collectors;
import lab2.dto.response.LessonDto;
import lab2.mapper.LessonMapper;
import lab2.model.Lesson;
import lab2.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lesson")
public class LessonController {
    private final AbstractService<Lesson> lessonService;
    private final LessonMapper lessonMapper;

    @GetMapping
    public List<LessonDto> findAll() {
        return lessonService.findAll().stream()
                .map(lessonMapper::lessonToLessonDto)
                .collect(Collectors.toList());
    }
}
