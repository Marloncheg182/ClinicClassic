package clinicspdata.services;

import clinicspdata.entity.Clinic;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Service Interface
 */
public interface ClinicService {

    Clinic create(Clinic clinic);

    Clinic getByName(String name);

    Clinic getById(Long id);

    List<Clinic> getAll();

    Clinic update(Clinic clinic);

    void delete(Long id);

}
