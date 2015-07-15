package clinicapp.service.serviceimpl;


import clinicapp.dao.CardDAO;
import clinicapp.entity.Card;
import clinicapp.service.CardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Card Implementation
 */

@Service
public class CardServiceImpl implements CardService {

    private CardDAO cardDAO;

    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    @Override
    @Transactional
    public void create(Card c) {
        this.cardDAO.create(c);
    }

    @Override
    @Transactional
    public Card getById(Long id) {
        return this.cardDAO.getById(id);
    }

    @Override
    @Transactional
    public Card getByLastName(String lastName) {
        return this.getByLastName(lastName);
    }

    @Override
    @Transactional
    public Card getByBirthDate(String birthDate) {
        return this.cardDAO.getByBirthDate(birthDate);
    }

    @Override
    @Transactional
    public List<Card> getAll() {
        return this.cardDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Card c) {
        this.cardDAO.update(c);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.cardDAO.delete(id);
    }
}
