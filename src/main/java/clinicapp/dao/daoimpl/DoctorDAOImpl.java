package clinicapp.dao.daoimpl;

import clinicapp.dao.DoctorDAO;
import clinicapp.entity.Doctor;
import clinicapp.entity.doctors.DoctorPosition;
import clinicapp.entity.doctors.Rating;
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
public class DoctorDAOImpl implements DoctorDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void create(Doctor d) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(d);
        logger.info("Doctor created, " + d);
    }

    @Override
    public Doctor getByFirstName(String firstName) {
        Session session = this.sessionFactory.getCurrentSession();
        Doctor d = (Doctor)session.load(Doctor.class, new String(firstName));
        logger.info("Doctor loaded by First Name" + d);

        return d;
    }

    @Override
    public Doctor getByLastName(String lastName) {
        Session session = this.sessionFactory.getCurrentSession();
        Doctor d = (Doctor)session.load(Doctor.class, new String(lastName));
        logger.info("Doctor loaded by Last Name" + d);

        return d;
    }

    @Override
    public Doctor getByAge(Integer age) {
        Session session = this.sessionFactory.getCurrentSession();
        Doctor d = (Doctor)session.load(Doctor.class, new Integer(age));
        logger.info("Doctor loaded by Age" + d);

        return d;
    }

    @Override
    public List<Doctor> getByPosition(DoctorPosition position) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Doctor> doctors = session.createSQLQuery("SELECT doctor.position FROM doctor").list();
        for (Doctor d : doctors)
        logger.info("Doctor loaded by Position" + d);

        return doctors;
    }

    @Override
    public List<Doctor> getByRating(Rating rating) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Doctor> doctors = session.createSQLQuery("SELECT doctor.rating FROM doctor").list();
        for (Doctor d : doctors)
        logger.info("Doctor loaded by Rating" + d);

        return doctors;
    }

    @Override
    public List<Doctor> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Doctor> doctors = session.createSQLQuery("SELECT * FROM doctor").list();
        for (Doctor d : doctors) {
            logger.info("Doctors :=" + d);
        }
        return doctors;
    }

    @Override
    public void update(Doctor d) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(d);
        logger.info("Doctor updated, " + d);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Doctor d = (Doctor) session.load(Doctor.class, new Long(id));
        if (null != d) {
            session.delete(d);
        }
        logger.info("Doctor deleted: " + d);
    }
}
