package clinicapp.dao.daoimpl;

import clinicapp.dao.AnalysisDAO;
import clinicapp.entity.Analysis;
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
public class AnalysisDAOImpl implements AnalysisDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public void create(Analysis a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        logger.info("Analysis created, " + a);

    }

    @Override
    public Analysis getById(Long id) {

        Session session = this.sessionFactory.getCurrentSession();
        Analysis a = (Analysis) session.load(Analysis.class, new Long(id));
        logger.info("Analysis loaded by Id " + a);

        return a;
    }

    @Override
    public Analysis getByDate(String date) {
        Session session = this.sessionFactory.getCurrentSession();
        Analysis a = (Analysis)session.load(Analysis.class, new String(date));
        logger.info("Analysis loaded by Date " + a);

        return a;
    }

    @SuppressWarnings("unchacked")
    @Override
    public List<Analysis> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Analysis> analysises = session.createSQLQuery("SELECT * FROM analysis").list();
        for (Analysis a : analysises) {
            logger.info("Analysis :=" + a);
        }
        return analysises;
    }

    @Override
    public void update(Analysis a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        logger.info("Analysis updated, " + a);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Analysis a = (Analysis) session.load(Analysis.class, new Long(id));
        if (null != a) {
            session.delete(a);
        }
        logger.info("Analysis deleted: " + a);
    }
}
