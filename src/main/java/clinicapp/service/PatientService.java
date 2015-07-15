package clinicapp.service;

import clinicapp.entity.Patient;
import clinicapp.entity.patients.PatientState;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Patient Service
 */
public interface PatientService {

    void create(Patient p);

    Patient getByFirstName(String firstName);

    Patient getByLastName(String lastName);

    Patient getByAge(Integer age);

    List<Patient> getByState(PatientState state);

    List<Patient> getAll();

    void update(Patient p);

    void delete(Long id);


}
