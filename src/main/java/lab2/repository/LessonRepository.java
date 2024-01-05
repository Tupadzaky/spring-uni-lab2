package lab2.repository;

import java.util.List;
import lab2.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query("SELECT l FROM lessons l WHERE l.name = :name")
    List<Lesson> findByName(@Param("name") String name);
}
