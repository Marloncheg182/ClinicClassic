package clinicapp.dao;

import clinicapp.entity.Card;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */
public interface CardDAO {

    void  create(Card c);

    Card getById(Long id);

    Card getByLastName(String lastName);

    Card getByBirthDate(String birthDate);

    List<Card> getAll();

    void  update(Card c);

    void delete(Long id);
}
