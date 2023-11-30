package lab2.dto.request;

import java.util.List;
import lab2.model.Lesson;
import lombok.Data;

@Data
public class JournalRequestDto {
    private String studentName;

    private List<Integer> lessonIds;
}
