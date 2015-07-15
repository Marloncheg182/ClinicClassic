package clinicapp.entity;

import clinicapp.entity.doctors.DoctorPosition;
import clinicapp.entity.doctors.Rating;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@ManagedBean
@Table(name = "doctor")
public class Doctor {

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
    private DoctorPosition position;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "rating")
    private Rating rating;

    // creating of relations between Doctor table and Clinic.
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, int age, DoctorPosition position, String phoneNumber, Rating rating, Clinic clinic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
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

    public DoctorPosition getPosition() {
        return position;
    }

    public void setPosition(DoctorPosition position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rating=" + rating +
                ", clinic=" + clinic +
                '}';
    }
}
