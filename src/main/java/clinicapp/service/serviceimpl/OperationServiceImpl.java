package clinicapp.service.serviceimpl;

import clinicapp.dao.OperationDAO;
import clinicapp.entity.Operation;
import clinicapp.service.OperationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class OperationServiceImpl implements OperationService {

    private OperationDAO operationDAO;

    public void setOperationDAO(OperationDAO operationDAO) {
        this.operationDAO = operationDAO;
    }

    @Override
    @Transactional
    public void create(Operation o) {
        this.operationDAO.create(o);
    }

    @Override
    @Transactional
    public Operation getById(Long id) {
        return this.operationDAO.getById(id);
    }

    @Override
    @Transactional
    public Operation getByDate(String date) {
        return this.operationDAO.getByDate(date);
    }

    @Override
    @Transactional
    public Operation getByType(String type) {
        return this.operationDAO.getByType(type);
    }

    @Override
    @Transactional
    public List<Operation> getAll() {
        return this.operationDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Operation o) {
        this.operationDAO.update(o);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.operationDAO.delete(id);
    }
}
