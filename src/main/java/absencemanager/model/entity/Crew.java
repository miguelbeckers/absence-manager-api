package absencemanager.model.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CREWS")
public class Crew {
    @Id
    private Long id;
    private String name;
    @OneToMany(cascade = {CascadeType.ALL})
    @Setter(AccessLevel.NONE)
    private List<User> users = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    @Setter(AccessLevel.NONE)
    private List<Absence> absences = new ArrayList<>();

    public void insertUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void insertAbsence(Absence absence) {
        absences.add(absence);
    }

    public void removeAbsence(Absence absence) {
        absences.remove(absence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return Objects.equals(id, crew.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}