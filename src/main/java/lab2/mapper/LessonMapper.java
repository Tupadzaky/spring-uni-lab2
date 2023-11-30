package lab2.mapper;

import lab2.config.MapperConfig;
import lab2.dto.request.LessonRequestDto;
import lab2.dto.response.LessonResponseDto;
import lab2.model.Grade;
import lab2.model.Lesson;
import lab2.service.AbstractService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(config = MapperConfig.class)
public abstract class LessonMapper {
    @Autowired
    private AbstractService<Grade> gradeService;

    public abstract LessonResponseDto lessonToLessonDto(Lesson lesson);

    @Mapping(target = "grade", source = "lessonRequestDto.gradeId", qualifiedByName = "getGradeById")
    public abstract Lesson lessonRequestDtoToLesson(LessonRequestDto lessonRequestDto);

    @Named("getGradeById")
    protected Grade getGradeById(Long id) {
        return gradeService.findById(id);
    }
}
