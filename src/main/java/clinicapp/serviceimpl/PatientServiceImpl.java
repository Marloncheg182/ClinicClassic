package clinicspdata.serviceimpl;

import clinicspdata.entity.Patient;
import clinicspdata.entity.patients.PatientState;
import clinicspdata.repositories.PatientRepository;
import clinicspdata.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient create(Patient patient) {
        return this.patientRepository.saveAndFlush(patient);
    }

    @Override
    public Patient getByFirstName(String firstName) {
        return this.patientRepository.finByFirstName(firstName);
    }

    @Override
    public Patient getByLastName(String lastName) {
        return this.patientRepository.findByLastName(lastName);
    }

    @Override
    public Patient getByAge(Integer age) {
        return this.patientRepository.findByAge(age);
    }

    @Override
    public Patient getByState(PatientState state) {
        return this.patientRepository.findByStat(state);
    }

    @Override
    public List<Patient> getAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public Patient update(Patient patient) {
        return this.patientRepository.saveAndFlush(patient);
    }

    @Override
    public void delete(Long id) {
        this.patientRepository.delete(id);
    }
}
