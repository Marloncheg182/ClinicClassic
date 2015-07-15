package clinicapp.entity;



import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.List;



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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor")
    private List<Doctor> doctors;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "nurse")
    private List<Nurse> nurses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    private List<Patient> patients;

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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doctors=" + doctors +
                ", nurses=" + nurses +
                ", patients=" + patients +
                '}';
    }
}


