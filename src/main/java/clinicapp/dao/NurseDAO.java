package clinicapp.dao;

import clinicapp.entity.Nurse;
import clinicapp.entity.nurses.NursePosition;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
public interface NurseDAO {

    void create(Nurse n);

    Nurse getByFirstName(String firstName);

    Nurse getByLastName(String lastName);

    Nurse getByAge(Integer age);

    List<Nurse> getByPosition(NursePosition position);

    List<Nurse> getAll();

    void update(Nurse n);

    void delete(Long id);
}
