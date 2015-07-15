package clinicapp.dao.daoimpl;

import clinicapp.dao.ProcedureDAO;
import clinicapp.entity.Procedure;
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
public class ProcedureDAOImpl implements ProcedureDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public void create(Procedure p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Procedure created, " + p);
    }


    @Override
    public Procedure getById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Procedure p = (Procedure) session.load(Procedure.class, new Long(id));
        logger.info("Procedure loaded by Id " + p);

        return p;
    }

    @Override
    public Procedure getByDate(String date) {
        Session session = this.sessionFactory.getCurrentSession();
        Procedure p = (Procedure) session.load(Procedure.class, new String(date));
        logger.info("Procedure loaded by Date " + p);

        return p;
    }
    @SuppressWarnings("unchacked")
    @Override
    public List<Procedure> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Procedure> procedures = session.createSQLQuery("SELECT * FROM procedure ").list();
        for (Procedure p : procedures) {
            logger.info("Procedures :=" + p);
        }
        return procedures;
    }

    @Override
    public void update(Procedure p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Procedure updated, " + p);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Procedure p = (Procedure) session.load(Procedure.class, new Long(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Procedure  deleted: " + p);
    }
}
