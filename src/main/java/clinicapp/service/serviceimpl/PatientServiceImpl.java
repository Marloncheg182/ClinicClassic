package clinicapp.service.serviceimpl;


import clinicapp.dao.PatientDAO;
import clinicapp.entity.Patient;
import clinicapp.entity.patients.PatientState;
import clinicapp.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class PatientServiceImpl implements PatientService {

    private PatientDAO patientDAO;

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    @Transactional
    public void create(Patient p) {
        this.patientDAO.create(p);
    }

    @Override
    @Transactional
    public Patient getByFirstName(String firstName) {
        return this.patientDAO.getByFirstName(firstName);
    }

    @Override
    @Transactional
    public Patient getByLastName(String lastName) {
        return this.patientDAO.getByLastName(lastName);
    }

    @Override
    @Transactional
    public Patient getByAge(Integer age) {
        return this.patientDAO.getByAge(age);
    }

    @Override
    @Transactional
    public List<Patient> getByState(PatientState state) {
        return this.patientDAO.getByState(state);
    }

    @Override
    @Transactional
    public List<Patient> getAll() {
        return this.patientDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Patient p) {
        this.patientDAO.update(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.patientDAO.delete(id);
    }
}
