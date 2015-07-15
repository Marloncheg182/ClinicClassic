package clinicapp.service;

import clinicapp.entity.Operation;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Operation service
 */
public interface OperationService {

    void create (Operation o);

    Operation getById(Long id);

    Operation getByDate(String date);

    Operation getByType(String type);

    List<Operation> getAll();

    void update(Operation o);

    void delete(Long id);
}
