package lab2.mapper;

import lab2.config.MapperConfig;
import lab2.dto.response.GradeDto;
import lab2.model.Grade;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface GradeMapper {
    GradeDto gradeToGradeDto(Grade grade);
}
