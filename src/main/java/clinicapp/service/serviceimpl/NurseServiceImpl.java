package clinicspdata.serviceimpl;

import clinicspdata.entity.Nurse;
import clinicspdata.entity.nurses.NursePosition;
import clinicspdata.repositories.NurseRepository;
import clinicspdata.services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Nurse Implementation
 */
@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Override
    public Nurse create(Nurse nurse) {
        return this.nurseRepository.saveAndFlush(nurse);
    }

    @Override
    public Nurse getByFirstName(String firstName) {
        return this.nurseRepository.findByFirstName(firstName);
    }

    @Override
    public Nurse getByLastName(String lastName) {
        return this.nurseRepository.findByLastName(lastName);
    }

    @Override
    public Nurse getByAge(Integer age) {
        return this.nurseRepository.findByAge(age);
    }

    @Override
    public Nurse getByPosition(NursePosition position) {
        return this.nurseRepository.findByPosition(position);
    }

    @Override
    public List<Nurse> getAll() {
        return this.nurseRepository.findAll();
    }

    @Override
    public Nurse update(Nurse nurse) {
        return this.nurseRepository.saveAndFlush(nurse);
    }

    @Override
    public void delete(Long id) {
        this.nurseRepository.delete(id);
    }
}
