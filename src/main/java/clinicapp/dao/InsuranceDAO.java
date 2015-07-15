package clinicapp.dao;

import clinicapp.entity.Insurance;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
public interface InsuranceDAO {

    void create(Insurance i);

    Insurance getById(Long id);

    List<Insurance> getAll();

    void update(Insurance i);

    void delete(Long id);
}
