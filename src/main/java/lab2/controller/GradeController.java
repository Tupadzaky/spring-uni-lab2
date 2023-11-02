package lab2.controller;

import java.util.List;
import java.util.stream.Collectors;
import lab2.dto.response.GradeDto;
import lab2.mapper.GradeMapper;
import lab2.model.Grade;
import lab2.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {
    private final AbstractService<Grade> gradeService;
    private final GradeMapper gradeMapper;

    @GetMapping
    public List<GradeDto> findAll() {
        return gradeService.findAll().stream()
                .map(gradeMapper::gradeToGradeDto)
                .collect(Collectors.toList());
    }
}
