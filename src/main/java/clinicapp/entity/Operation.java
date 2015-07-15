package clinicapp.entity;



import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@ManagedBean
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private String type;

    @Column(name = "result")
    private String result;

    // add the relations between Operation table and Card
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public Operation() {
    }

    public Operation(String date, String type, String result, Card card) {
        this.date = date;
        this.type = type;
        this.result = result;
        this.card = card;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", result='" + result + '\'' +
                ", card=" + card +
                '}';
    }
}
