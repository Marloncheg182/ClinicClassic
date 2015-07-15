package clinicapp.dao.daoimpl;

import clinicapp.dao.CardDAO;
import clinicapp.entity.Card;
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
public class CardDAOImpl implements CardDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void create(Card c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Card created, " + c);
    }

    @Override
    public Card getById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Card c = (Card)session.load(Card.class, new Long(id));
        logger.info("Card loaded by Id " + c);

        return c;
    }

    @Override
    public Card getByLastName(String lastName) {
        Session session = this.sessionFactory.getCurrentSession();
        Card c = (Card)session.load(Card.class, new String(lastName));
        logger.info("Card loaded by Last Name" + c);

        return c;
    }

    @Override
    public Card getByBirthDate(String birthDate) {
        Session session = this.sessionFactory.getCurrentSession();
        Card c = (Card)session.load(Card.class, new String(birthDate));
        logger.info("Card loaded by Birth Date " + c);

        return c;
    }

    @SuppressWarnings("unchacked")
    @Override
    public List<Card> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Card> cards = session.createSQLQuery("SELECT * FROM card").list();
        for (Card c : cards) {
            logger.info("Cards :=" + c);
        }
        return cards;
    }

    @Override
    public void update(Card c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("Card updated, " + c);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Card c = (Card) session.load(Card.class, new Long(id));
        if (null != c) {
            session.delete(c);
        }
        logger.info("Card deleted: " + c);
    }
}
