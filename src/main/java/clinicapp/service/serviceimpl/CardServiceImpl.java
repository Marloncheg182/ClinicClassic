package clinicspdata.serviceimpl;

import clinicspdata.entity.Card;
import clinicspdata.repositories.CardRepository;
import clinicspdata.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Card Implementation
 */

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;   // Card repository included

    @Override
    public Card create(Card card) {
        return this.cardRepository.saveAndFlush(card);
    }

    @Override
    public Card getById(Long id) {
        return this.cardRepository.findById(id);
    }

    @Override
    public Card getByLastName(String lastName) {
        return this.cardRepository.findByName(lastName);
    }

    @Override
    public Card getByBirthDate(String birthDate) {
        return this.cardRepository.findByBirthDate(birthDate);
    }

    @Override
    public List<Card> getAll() {
        return this.cardRepository.findAll();
    }

    @Override
    public Card update(Card card) {
        return this.cardRepository.saveAndFlush(card);
    }

    @Override
    public void delete(Long id) {
        cardRepository.delete(id);
    }
}
