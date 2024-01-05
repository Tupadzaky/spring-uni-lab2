package lab2.repository;

import java.util.List;
import lab2.model.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    Page<Grade> findByMarkEquals(Integer mark, Pageable pageable);

    List<Grade> findByMark(@Param("mark") Integer mark);
}
