package clinicspdata.serviceimpl;

import clinicspdata.entity.Clinic;
import clinicspdata.repositories.ClinicRepository;
import clinicspdata.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Clinic implementation
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository repository;   // Working with Clinic repository CRUD access

    @Override
    public Clinic create(Clinic clinic) {
        return this.repository.saveAndFlush(clinic);
    }

    @Override
    public Clinic getByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public Clinic getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Clinic> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Clinic update(Clinic clinic) {
        return this.repository.saveAndFlush(clinic);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);

    }
}
