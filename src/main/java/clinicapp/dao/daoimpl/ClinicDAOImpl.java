package clinicapp.dao.daoimpl;

import clinicapp.dao.ClinicDAO;
import clinicapp.entity.Clinic;
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
public class ClinicDAOImpl implements ClinicDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void create(Clinic c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Clinic created, " + c);
    }


    @Override
    public Clinic getByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Clinic c = (Clinic) session.load(Clinic.class, new String(name));
        logger.info("Clinic loaded by name" + c);

        return c;
    }

    @Override
    public Clinic getById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Clinic c = (Clinic) session.load(Clinic.class, new Long(id));
        logger.info("Clinic loaded by Id " + c);

        return c;
    }

    @SuppressWarnings("unchacked")
    @Override
    public List<Clinic> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Clinic> clinics = session.createSQLQuery("SELECT * FROM clinic").list();
        for (Clinic c : clinics) {
            logger.info("Clinics :=" + c);
        }
        return clinics;
    }

    @Override
    public void update(Clinic c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("Clinic updated, " + c);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Clinic c = (Clinic) session.load(Clinic.class, new Long(id));
        if (null != c) {
            session.delete(c);
        }
        logger.info("Clinic deleted: " + c);
    }
}
