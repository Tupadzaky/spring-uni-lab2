package lab2.dto.response;

import lab2.model.Grade;

public record LessonResponseDto(Long id, String name, Grade grade) {
}
