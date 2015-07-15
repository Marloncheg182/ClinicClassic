package clinicapp.entity;



import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@Table(name = "analysis")
@ManagedBean
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "notes")
    private String notes;


    // add the relations between Analysis table and Card
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public Analysis() {
    }

    public Analysis(String date, String notes, Card card) {
        this.date = date;
        this.notes = notes;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", notes='" + notes + '\'' +
                ", card=" + card +
                '}';
    }
}
