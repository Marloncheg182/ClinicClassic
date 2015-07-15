package clinicspdata.serviceimpl;

import clinicspdata.entity.Procedure;
import clinicspdata.repositories.ProcedureRepository;
import clinicspdata.services.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public Procedure create(Procedure procedure) {
        return this.procedureRepository.saveAndFlush(procedure);
    }

    @Override
    public Procedure getById(Long id) {
        return this.procedureRepository.findById(id);
    }

    @Override
    public Procedure getByDate(String date) {
        return this.procedureRepository.findByDate(date);
    }

    @Override
    public List<Procedure> getAll() {
        return this.procedureRepository.findAll();
    }

    @Override
    public Procedure update(Procedure procedure) {
        return this.procedureRepository.saveAndFlush(procedure);
    }

    @Override
    public void delete(Long id) {
        this.procedureRepository.delete(id);
    }
}
