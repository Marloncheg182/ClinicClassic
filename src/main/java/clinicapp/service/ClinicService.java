package clinicapp.service;



import clinicapp.entity.Clinic;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Service Interface
 */
public interface ClinicService {

    void create(Clinic c);

    Clinic getByName(String name);

    Clinic getById(Long id);

    List<Clinic> getAll();

    void update(Clinic c);

    void delete(Long id);

}
