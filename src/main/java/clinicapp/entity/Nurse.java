package clinicapp.entity;


import clinicapp.entity.nurses.NursePosition;


import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@ManagedBean
@Table(name = "nurse")
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private NursePosition position;

    @Column(name = "phone_number")
    private String phoneNumber;

    // creating of relations between Nurse table and Clinic.
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "clinic_id", unique = true, nullable = false)
    private Clinic clinic;

    public Nurse() {
    }

    public Nurse(String firstName, String lastName, int age, NursePosition position, String phoneNumber, Clinic clinic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.clinic = clinic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public NursePosition getPosition() {
        return position;
    }

    public void setPosition(NursePosition position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", clinic=" + clinic +
                '}';
    }
}
