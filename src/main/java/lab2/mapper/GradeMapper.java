package lab2.mapper;

import lab2.config.MapperConfig;
import lab2.dto.request.GradeRequestDto;
import lab2.dto.response.GradeResponseDto;
import lab2.model.Grade;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public abstract class GradeMapper {
    public abstract GradeResponseDto gradeToGradeDto(Grade grade);

    public abstract Grade gradeRequestDtoToGrade(GradeRequestDto requestDto);
}
