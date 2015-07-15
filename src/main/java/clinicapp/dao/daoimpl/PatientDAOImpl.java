package clinicapp.dao.daoimpl;

import clinicapp.dao.PatientDAO;
import clinicapp.entity.Patient;
import clinicapp.entity.patients.PatientState;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
@Repository
public class PatientDAOImpl implements PatientDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void create(Patient p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Patient created, " + p);
    }


    @Override
    public Patient getByFirstName(String firstName) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient p = (Patient) session.load(Patient.class, new String(firstName));
        logger.info("Patient loaded by First Name" + p);

        return p;
    }

    @Override
    public Patient getByLastName(String lastName) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient p = (Patient) session.load(Patient.class, new String(lastName));
        logger.info("Patient loaded by Last Name" + p);

        return p;
    }

    @Override
    public Patient getByAge(Integer age) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient p = (Patient) session.load(Patient.class, new Integer(age));
        logger.info("Patient loaded by Age" + p);

        return p;
    }

    @Override
    public List<Patient> getByState(PatientState state) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Patient> patients = session.createSQLQuery("SELECT patient.state FROM patient").list();
        for (Patient p : patients)
            logger.info("Patient loaded by State" + p);

        return patients;
    }

    @Override
    public List<Patient> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Patient> patients = session.createSQLQuery("SELECT * FROM patient").list();
        for (Patient p : patients) {
            logger.info("Patient :=" + p);
        }
        return patients;
    }

    @Override
    public void update(Patient p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Nurse updated, " + p);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient p = (Patient) session.load(Patient.class, new Long(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Nurse deleted: " + p);
    }
}
