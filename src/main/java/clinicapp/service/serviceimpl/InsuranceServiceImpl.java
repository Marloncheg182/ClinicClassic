package clinicapp.service.serviceimpl;


import clinicapp.dao.InsuranceDAO;
import clinicapp.entity.Insurance;
import clinicapp.service.InsuranceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    private InsuranceDAO insuranceDAO;

    public void setInsuranceDAO(InsuranceDAO insuranceDAO) {
        this.insuranceDAO = insuranceDAO;
    }

    @Override
    @Transactional
    public void create(Insurance i) {
        this.insuranceDAO.create(i);
    }

    @Override
    @Transactional
    public Insurance getById(Long id) {
        return this.insuranceDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Insurance> getAll() {
        return this.insuranceDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Insurance i) {
        this.insuranceDAO.update(i);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.insuranceDAO.delete(id);
    }
}


