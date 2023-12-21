package lab2.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.stream.Collectors;
import lab2.dto.request.LessonRequestDto;
import lab2.dto.response.LessonResponseDto;
import lab2.mapper.LessonMapper;
import lab2.model.Lesson;
import lab2.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lessons")
public class LessonController {
    private final AbstractService<Lesson> lessonService;
    private final LessonMapper lessonMapper;

    @Operation(summary = "Get all lessons", description = "List of all lessons")
    @GetMapping
    public List<LessonResponseDto> findAll() {
        return lessonService.findAll().stream()
            .map(lessonMapper::lessonToLessonDto)
            .collect(Collectors.toList());
    }

    @Operation(summary = "Get lesson by id", description = "Get lesson by id")
    @GetMapping("/{id}")
    public LessonResponseDto findById(@PathVariable Long id) {
        return lessonMapper.lessonToLessonDto(lessonService.findById(id));
    }

    @Operation(summary = "Create lesson", description = "Create lesson")
    @PostMapping
    public LessonResponseDto save(@RequestBody LessonRequestDto requestDto) {
        return lessonMapper.lessonToLessonDto(lessonService.save(lessonMapper.lessonRequestDtoToLesson(requestDto)));
    }

    @Operation(summary = "Update lesson by id", description = "Update lesson by id")
    @PutMapping("/{id}")
    public LessonResponseDto update(@PathVariable Long id, @RequestBody LessonRequestDto requestDto) {
        Lesson lesson = lessonMapper.lessonRequestDtoToLesson(requestDto);
        lesson.setId(id);
        return lessonMapper.lessonToLessonDto(lessonService.update(lesson));
    }

    @Operation(summary = "Delete lesson by id", description = "Delete lesson by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lessonService.deleteById(id);
    }
}
