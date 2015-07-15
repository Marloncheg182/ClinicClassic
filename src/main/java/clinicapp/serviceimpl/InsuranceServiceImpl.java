package clinicspdata.serviceimpl;

import clinicspdata.entity.Insurance;
import clinicspdata.repositories.InsuranceRepository;
import clinicspdata.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public Insurance create(Insurance insurance) {
        return this.insuranceRepository.saveAndFlush(insurance);
    }

    @Override
    public Insurance getById(Long id) {
        return this.insuranceRepository.findById(id);
    }

    @Override
    public List<Insurance> getAll() {
        return this.insuranceRepository.findAll();
    }

    @Override
    public Insurance update(Insurance insurance) {
        return this.insuranceRepository.saveAndFlush(insurance);
    }

    @Override
    public void delete(Long id) {
        insuranceRepository.delete(id);
    }
}
