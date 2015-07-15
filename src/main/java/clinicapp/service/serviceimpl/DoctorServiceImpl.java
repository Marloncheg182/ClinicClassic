package clinicapp.service.serviceimpl;


import clinicapp.dao.DoctorDAO;
import clinicapp.entity.Doctor;
import clinicapp.entity.doctors.DoctorPosition;
import clinicapp.entity.doctors.Rating;
import clinicapp.service.DoctorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Doctor implementation of service interface
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorDAO doctorDAO;

    public void setDoctorDAO(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @Override
    @Transactional
    public void create(Doctor d) {
        this.doctorDAO.create(d);
    }

    @Override
    @Transactional
    public Doctor getByFirstName(String firstName) {
        return this.doctorDAO.getByFirstName(firstName);
    }

    @Override
    @Transactional
    public Doctor getByLastName(String lastName) {
        return this.doctorDAO.getByLastName(lastName);
    }

    @Override
    @Transactional
    public Doctor getByAge(Integer age) {
        return this.getByAge(age);
    }

    @Override
    @Transactional
    public List<Doctor> getByPosition(DoctorPosition position) {
        return this.doctorDAO.getAll();
    }

    @Override
    @Transactional
    public List<Doctor> getByRating(Rating rating) {
        return this.doctorDAO.getByRating(rating);
    }

    @Override
    @Transactional
    public List<Doctor> getAll() {
        return this.doctorDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Doctor d) {
        this.doctorDAO.update(d);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.doctorDAO.delete(id);
    }
}
