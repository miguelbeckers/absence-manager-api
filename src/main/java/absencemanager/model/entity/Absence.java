package absencemanager.model.entity;

import absencemanager.model.enumerator.AbsenceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ABSENCES")
public class Absence {
    @Id
    private Long id;
    @ManyToOne
    private Crew crew;
    @ManyToOne
    private User user;
    @ManyToOne
    private User admitter;
    private ZonedDateTime createdAt;
    private ZonedDateTime confirmedAt;
    private ZonedDateTime rejectedAt;
    private Date startDate;
    private Date endDate;
    private AbsenceType type;
    private String admitterNote;
    private String memberNote;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Absence absence = (Absence) o;
        return Objects.equals(id, absence.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}