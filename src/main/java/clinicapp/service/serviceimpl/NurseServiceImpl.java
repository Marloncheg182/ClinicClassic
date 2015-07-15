package clinicapp.service.serviceimpl;


import clinicapp.dao.NurseDAO;
import clinicapp.entity.Nurse;
import clinicapp.entity.nurses.NursePosition;
import clinicapp.service.NurseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Nurse Implementation
 */
@Service
public class NurseServiceImpl implements NurseService {

    private NurseDAO nurseDAO;

    public void setNurseDAO(NurseDAO nurseDAO) {
        this.nurseDAO = nurseDAO;
    }

    @Override
    @Transactional
    public void create(Nurse n) {
        this.nurseDAO.create(n);
    }

    @Override
    @Transactional
    public Nurse getByFirstName(String firstName) {
        return this.nurseDAO.getByFirstName(firstName);
    }

    @Override
    @Transactional
    public Nurse getByLastName(String lastName) {
        return this.nurseDAO.getByLastName(lastName);
    }

    @Override
    @Transactional
    public Nurse getByAge(Integer age) {
        return this.nurseDAO.getByAge(age);
    }

    @Override
    @Transactional
    public List<Nurse> getByPosition(NursePosition position) {
        return this.nurseDAO.getByPosition(position);
    }

    @Override
    @Transactional
    public List<Nurse> getAll() {
        return this.nurseDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Nurse n) {
        this.nurseDAO.update(n);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.nurseDAO.delete(id);
    }
}
