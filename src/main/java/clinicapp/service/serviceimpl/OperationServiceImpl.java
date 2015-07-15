package clinicspdata.serviceimpl;

import clinicspdata.entity.Operation;
import clinicspdata.repositories.OperationRepository;
import clinicspdata.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Operation create(Operation operation) {
        return this.operationRepository.saveAndFlush(operation);
    }

    @Override
    public Operation getById(Long id) {
        return this.operationRepository.findById(id);
    }

    @Override
    public Operation getByDate(String date) {
        return this.operationRepository.findByDate(date);
    }

    @Override
    public Operation getByType(String type) {
        return this.operationRepository.findByType(type);
    }

    @Override
    public List<Operation> getAll() {
        return this.operationRepository.findAll();
    }

    @Override
    public Operation update(Operation operation) {
        return this.operationRepository.saveAndFlush(operation);
    }

    @Override
    public void delete(Long id) {
        this.operationRepository.delete(id);
    }
}
