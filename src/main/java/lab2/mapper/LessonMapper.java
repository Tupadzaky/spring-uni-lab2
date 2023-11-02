package lab2.mapper;

import lab2.config.MapperConfig;
import lab2.dto.response.LessonDto;
import lab2.model.Lesson;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface LessonMapper {
    LessonDto lessonToLessonDto(Lesson lesson);
}
