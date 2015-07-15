package clinicapp.dao;

import clinicapp.entity.Clinic;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
public interface ClinicDAO {

    void create(Clinic c);

    Clinic getByName(String name);

    Clinic getById(Long id);

    List<Clinic> getAll();

    void update(Clinic c);

    void delete(Long id);
}
