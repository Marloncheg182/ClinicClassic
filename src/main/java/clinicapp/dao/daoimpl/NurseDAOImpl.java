package clinicapp.dao.daoimpl;

import clinicapp.dao.NurseDAO;
import clinicapp.entity.Nurse;
import clinicapp.entity.nurses.NursePosition;
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
public class NurseDAOImpl implements NurseDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void create(Nurse n) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(n);
        logger.info("Nurse created, " + n);
    }

    @Override
    public Nurse getByFirstName(String firstName) {
        Session session = this.sessionFactory.getCurrentSession();
        Nurse n = (Nurse) session.load(Nurse.class, new String(firstName));
        logger.info("Nurse loaded by First Name" + n);

        return n;
    }

    @Override
    public Nurse getByLastName(String lastName) {
        Session session = this.sessionFactory.getCurrentSession();
        Nurse n = (Nurse) session.load(Nurse.class, new String(lastName));
        logger.info("Nurse loaded by Last Name" + n);

        return n;
    }

    @Override
    public Nurse getByAge(Integer age) {
        Session session = this.sessionFactory.getCurrentSession();
        Nurse n = (Nurse) session.load(Nurse.class, new Integer(age));
        logger.info("Nurse loaded by Age" + n);

        return n;
    }

    @Override
    public List<Nurse> getByPosition(NursePosition position) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Nurse> nurses = session.createSQLQuery("SELECT nurse.position FROM nurse").list();
        for (Nurse n : nurses)
            logger.info("Nurse loaded by Position" + n);

        return nurses;
    }
    @SuppressWarnings("unchacked")
    @Override
    public List<Nurse> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Nurse> nurses = session.createSQLQuery("SELECT * FROM nurse").list();
        for (Nurse n : nurses) {
            logger.info("Nurses :=" + n);
        }
        return nurses;
    }

    @Override
    public void update(Nurse n) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(n);
        logger.info("Nurse updated, " + n);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Nurse n = (Nurse) session.load(Nurse.class, new Long(id));
        if (null != n) {
            session.delete(n);
        }
        logger.info("Nurse deleted: " + n);
    }
}
