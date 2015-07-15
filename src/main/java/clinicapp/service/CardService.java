package clinicapp.service;

import clinicapp.entity.Card;


import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Card Service
 */
public interface CardService {

    void  create(Card c);

    Card getById(Long id);

    Card getByLastName(String lastName);

    Card getByBirthDate(String birthDate);

    List<Card> getAll();

    void  update(Card c);

    void delete(Long id);

}
