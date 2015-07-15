package clinicapp.service.serviceimpl;


import clinicapp.dao.ProcedureDAO;
import clinicapp.entity.Procedure;
import clinicapp.service.ProcedureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class ProcedureServiceImpl implements ProcedureService {

    private ProcedureDAO procedureDAO;

    public void setProcedureDAO(ProcedureDAO procedureDAO) {
        this.procedureDAO = procedureDAO;
    }

    @Override
    @Transactional
    public void create(Procedure p) {
        this.procedureDAO.create(p);
    }

    @Override
    @Transactional
    public Procedure getById(Long id) {
        return this.procedureDAO.getById(id);
    }

    @Override
    @Transactional
    public Procedure getByDate(String date) {
        return this.procedureDAO.getByDate(date);
    }

    @Override
    @Transactional
    public List<Procedure> getAll() {
        return this.procedureDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Procedure p) {
        this.procedureDAO.update(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.procedureDAO.delete(id);
    }
}
