package lab2.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.stream.Collectors;
import lab2.dto.request.GradeRequestDto;
import lab2.dto.response.GradeResponseDto;
import lab2.mapper.GradeMapper;
import lab2.model.Grade;
import lab2.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/grades")
public class GradeController {
    private final GradeService gradeService;
    private final GradeMapper gradeMapper;

    @Operation(summary = "Get all grades with filter/pagination",
            description = "List of all grades with filter/pagination")
    @GetMapping
    public List<GradeResponseDto> findAll(@RequestParam(required = false) String mark,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "3") int size) {

        return gradeService.findByMarkContaining(mark, page, size).stream()
                .map(gradeMapper::gradeToGradeDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Get grade by id", description = "Get grade by id")
    @GetMapping("/{id}")
    public GradeResponseDto findById(@PathVariable Long id) {
        return gradeMapper.gradeToGradeDto(gradeService.findById(id));
    }

    @Operation(summary = "Create grade", description = "Create grade")
    @PostMapping
    public GradeResponseDto save(@RequestBody GradeRequestDto requestDto) {
        return gradeMapper.gradeToGradeDto(gradeService.save(gradeMapper.gradeRequestDtoToGrade(requestDto)));
    }

    @Operation(summary = "Update grade by id", description = "Update grade by id")
    @PutMapping("/{id}")
    public GradeResponseDto update(@PathVariable Long id, @RequestBody GradeRequestDto requestDto) {
        Grade grade = gradeMapper.gradeRequestDtoToGrade(requestDto);
        grade.setId(id);
        return gradeMapper.gradeToGradeDto(gradeService.update(grade));
    }

    @Operation(summary = "Delete grade by id", description = "Delete grade by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gradeService.deleteById(id);
    }
}
