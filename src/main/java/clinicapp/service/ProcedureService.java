package clinicapp.service;



import clinicapp.entity.Procedure;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Procedure Service
 */
public interface ProcedureService  {

    void create(Procedure p);

    Procedure getById(Long id);

    Procedure getByDate(String date);

    List<Procedure> getAll();

    void update(Procedure p);

    void delete(Long id);
}
