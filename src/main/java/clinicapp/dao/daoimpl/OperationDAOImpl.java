package clinicapp.dao.daoimpl;

import clinicapp.dao.OperationDAO;
import clinicapp.entity.Operation;
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
public class OperationDAOImpl implements OperationDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void create(Operation o) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(o);
        logger.info("Operation created, " + o);

    }

    @Override
    public Operation getById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Operation o = (Operation)session.load(Operation.class, new Long(id));
        logger.info("Operation loaded by Id " + o);

        return o;
    }

    @Override
    public Operation getByDate(String date) {
        Session session = this.sessionFactory.getCurrentSession();
        Operation o = (Operation)session.load(Operation.class, new String(date));
        logger.info("Operation loaded by Date " + o);

        return o;
    }

    @Override
    public Operation getByType(String type) {
        Session session = this.sessionFactory.getCurrentSession();
        Operation o = (Operation)session.load(Operation.class, new String(type));
        logger.info("Operation loaded by Type " + o);

        return o;
    }

    @Override
    public List<Operation> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Operation> operations = session.createSQLQuery("SELECT * FROM operation").list();
        for (Operation o : operations) {
            logger.info("Operations :=" + o);
        }
        return operations;
    }

    @Override
    public void update(Operation o) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(o);
        logger.info("Operation updated, " + o);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Operation o = (Operation) session.load(Operation.class, new Long(id));
        if (null != o) {
            session.delete(o);
        }
        logger.info("Operation deleted: " + o);
    }
}
