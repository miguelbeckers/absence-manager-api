package absencemanager.model.dto;

import absencemanager.model.enumerator.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private Long crewId;
    private String name;
    private String image;
    private String email;
    private UserType type;
}
