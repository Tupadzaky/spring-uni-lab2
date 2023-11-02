package lab2.mapper;

import lab2.config.MapperConfig;
import lab2.dto.response.JournalDto;
import lab2.model.Journal;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface JournalMapper {

    JournalDto journalToJournalDto(Journal journal);
}
