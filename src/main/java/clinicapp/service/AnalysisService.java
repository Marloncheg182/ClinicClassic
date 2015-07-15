package clinicapp.service;

import clinicapp.entity.Analysis;


import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Service interface
 */
public interface AnalysisService {

    void create(Analysis a);

    Analysis getById(Long id);

    Analysis getByDate(String date);

    List<Analysis> getAll();

    void update(Analysis a);

    void delete(Long id);

}
