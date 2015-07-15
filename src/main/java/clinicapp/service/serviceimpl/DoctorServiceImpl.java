package clinicspdata.serviceimpl;

import clinicspdata.entity.Doctor;
import clinicspdata.entity.doctors.DoctorPosition;
import clinicspdata.entity.doctors.Rating;
import clinicspdata.repositories.DoctorRepository;
import clinicspdata.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Doctor implementation of service interface
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;  // Doctor repository included

    @Override
    public Doctor create(Doctor doctor) {
        return this.doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public Doctor getByFirstName(String firstName) {
        return this.doctorRepository.findByFirstName(firstName);
    }

    @Override
    public Doctor getByLastName(String lastName) {
        return this.doctorRepository.findByLastName(lastName);
    }

    @Override
    public Doctor getByAge(Integer age) {
        return this.doctorRepository.findByAge(age);
    }

    @Override
    public Doctor getByPosition(DoctorPosition position) {
        return this.doctorRepository.findByPosition(position);
    }

    @Override
    public Doctor getByRating(Rating rating) {
        return this.doctorRepository.findByRating(rating);
    }

    @Override
    public List<Doctor> getAll() {
        return this.doctorRepository.findAll();
    }

    @Override
    public Doctor update(Doctor doctor) {
        return this.doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public void delete(Long id) {
        this.doctorRepository.delete(id);
    }
}
