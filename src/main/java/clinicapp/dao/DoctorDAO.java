package clinicapp.dao;

import clinicapp.entity.Doctor;
import clinicapp.entity.doctors.DoctorPosition;
import clinicapp.entity.doctors.Rating;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
public interface DoctorDAO {

    void create(Doctor d);

    Doctor getByFirstName(String firstName);

    Doctor getByLastName(String lastName);

    Doctor getByAge(Integer age);

    List<Doctor> getByPosition(DoctorPosition position);

    List<Doctor> getByRating(Rating rating);

    List<Doctor> getAll();

    void update(Doctor d);

    void delete(Long id);
}
