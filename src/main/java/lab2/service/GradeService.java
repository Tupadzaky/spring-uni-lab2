package lab2.service;

import lab2.model.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GradeService extends AbstractService<Grade> {
    Page<Grade> findByMarkContaining(String mark, int page, int size);

    Page<Grade> findAll(Pageable pageable);
}
