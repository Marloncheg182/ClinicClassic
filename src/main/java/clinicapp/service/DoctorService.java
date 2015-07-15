package clinicspdata.services;

import clinicspdata.entity.Doctor;
import clinicspdata.entity.doctors.DoctorPosition;
import clinicspdata.entity.doctors.Rating;


import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Doctor Serivce
 */
public interface DoctorService {

    Doctor create(Doctor doctor);

    Doctor getByFirstName(String firstName);

    Doctor getByLastName(String lastName);

    Doctor getByAge(Integer age);

    Doctor getByPosition(DoctorPosition position);

    Doctor getByRating(Rating rating);

    List<Doctor> getAll();

    Doctor update(Doctor doctor);

    void delete(Long id);


}
