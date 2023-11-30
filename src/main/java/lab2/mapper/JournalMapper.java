package lab2.mapper;

import lab2.config.MapperConfig;
import lab2.dto.request.JournalRequestDto;
import lab2.dto.response.JournalResponseDto;
import lab2.model.Grade;
import lab2.model.Journal;
import lab2.model.Lesson;
import lab2.service.AbstractService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(config = MapperConfig.class)
public abstract class JournalMapper {
    @Autowired
    private AbstractService<Lesson> lessonService;

    public abstract JournalResponseDto journalToJournalDto(Journal journal);

    @Mapping(target = "lessons", source = "requestDto.lessonIds", qualifiedByName = "getLessonById")
    public abstract Journal journalRequestToJournal(JournalRequestDto requestDto);

    @Named("getLessonById")
    protected Lesson getLessonById(Long id) {
        return lessonService.findById(id);
    }
}
