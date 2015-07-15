package clinicapp.dao.daoimpl;

import clinicapp.dao.InsuranceDAO;
import clinicapp.entity.Insurance;
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
public class InsuranceDAOImpl implements InsuranceDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void create(Insurance i) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(i);
        logger.info("Insurance created, " + i);
    }

    @Override
    public Insurance getById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Insurance i = (Insurance) session.load(Insurance.class, new Long(id));
        logger.info("Insurance loaded by Id " + i);

        return i;
    }

    @Override
    public List<Insurance> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Insurance> insurances = session.createSQLQuery("SELECT * FROM insurance").list();
        for (Insurance i : insurances) {
            logger.info("Insurance :=" + i);
        }
        return insurances;
    }

    @Override
    public void update(Insurance i) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(i);
        logger.info("Insurance updated, " + i);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Insurance i = (Insurance) session.load(Insurance.class, new Long(id));
        if (null != i) {
            session.delete(i);
        }
        logger.info("Insurance deleted: " + i);
    }
}

