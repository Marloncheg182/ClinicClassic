package clinicapp.dao;

import clinicapp.entity.Analysis;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
public interface AnalysisDAO {

    void create(Analysis a);

    Analysis getById(Long id);

    Analysis getByDate(String date);

    List<Analysis> getAll();

    void update(Analysis a);

    void delete(Long id);
}
