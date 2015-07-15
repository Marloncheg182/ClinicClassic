package clinicspdata.services;

import clinicspdata.entity.Operation;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Operation service
 */
public interface OperationService {

    Operation create (Operation operation);

    Operation getById(Long id);

    Operation getByDate(String date);

    Operation getByType(String type);

    List<Operation> getAll();

    Operation update(Operation operation);

    void delete(Long id);
}
