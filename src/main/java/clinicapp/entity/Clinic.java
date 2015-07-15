package clinicapp.entity;



import javax.faces.bean.ManagedBean;
import javax.persistence.*;


@Entity
@ManagedBean
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 6, nullable = false)
    private  int id;

    @Column(name = "name")
    private String name;

    public Clinic() {
    }

    public Clinic(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
