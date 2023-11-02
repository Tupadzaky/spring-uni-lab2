package lab2.dto.response;

import lab2.model.Grade;

public record LessonDto(Long id, String name, Grade grade) {
}
