package absencemanager.model.entity;

import absencemanager.model.enumerator.UserType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "USERS")
public class User {
    @Id
    private Long id;
    private String name;
    private UserType type;
    private String image;
    private String email;
    @ManyToOne
    private Crew crew;
    @OneToMany(cascade = {CascadeType.ALL})
    @Setter(AccessLevel.NONE)
    private List<Absence> absences = new ArrayList<>();

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
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
