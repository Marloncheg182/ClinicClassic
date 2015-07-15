package clinicapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@ManagedBean
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "bank_account")
    private int bankAccount;

    // creating of relations between Insurance table and Card.
    @OneToOne(optional = false, targetEntity = Card.class)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public Insurance() {
    }

    public Insurance(int bankAccount, Card card) {
        this.bankAccount = bankAccount;
        this.card = card;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", bankAccount=" + bankAccount +
                ", card=" + card +
                '}';
    }
}
