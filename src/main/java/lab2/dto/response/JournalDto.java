package lab2.dto.response;

import java.util.List;
import lab2.model.Lesson;

public record JournalDto(Long id, String studentName, List<Lesson> lessons) {
}
