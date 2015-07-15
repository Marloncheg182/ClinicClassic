package clinicspdata.services;

import clinicspdata.entity.Procedure;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Procedure Service
 */
public interface ProcedureService  {

    Procedure create(Procedure procedure);

    Procedure getById(Long id);

    Procedure getByDate(String date);

    List<Procedure> getAll();

    Procedure update(Procedure procedure);

    void delete(Long id);
}
