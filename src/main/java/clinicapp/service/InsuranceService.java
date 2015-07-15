package clinicspdata.services;

import clinicspdata.entity.Insurance;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
public interface InsuranceService {

    Insurance create(Insurance insurance);

    Insurance getById(Long id);

    List<Insurance> getAll();

    Insurance update(Insurance insurance);

    void delete(Long id);


}
