package clinicapp.dao;

import clinicapp.entity.Operation;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
public interface OperationDAO {

    void create (Operation o);

    Operation getById(Long id);

    Operation getByDate(String date);

    Operation getByType(String type);

    List<Operation> getAll();

    void update(Operation o);

    void delete(Long id);
}
