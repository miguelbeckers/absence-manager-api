package absencemanager.model.dto;

import absencemanager.model.enumerator.AbsenceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Date;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AbsenceDTO {
    private Long id;
    private Long crewId;
    private Long userId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long admitterId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime createdAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime confirmedAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ZonedDateTime rejectedAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String admitterNote;
    private String memberNote;
    private Date startDate;
    private Date endDate;
    private AbsenceType type;
}
