package clinicapp.service.serviceimpl;



import clinicapp.dao.ClinicDAO;
import clinicapp.entity.Clinic;
import clinicapp.service.ClinicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Clinic implementation
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    private ClinicDAO clinicDAO;

    public void setClinicDAO(ClinicDAO clinicDAO) {
        this.clinicDAO = clinicDAO;
    }

    @Override
    @Transactional
    public void create(Clinic c) {
        this.clinicDAO.create(c);
    }

    @Override
    @Transactional
    public Clinic getByName(String name) {
        return this.clinicDAO.getByName(name);
    }

    @Override
    @Transactional
    public Clinic getById(Long id) {
        return this.clinicDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Clinic> getAll() {
        return this.clinicDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Clinic c) {
        this.clinicDAO.update(c);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.clinicDAO.delete(id);
    }
}

