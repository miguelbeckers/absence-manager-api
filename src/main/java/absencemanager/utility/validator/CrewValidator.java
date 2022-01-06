package absencemanager.utility.validator;

import absencemanager.model.entity.Crew;
import absencemanager.utility.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class CrewValidator {
    public void validate(Crew crew) {
        if (crew.getName() == null) throw new BadRequestException("Name cannot be null");
        if (crew.getName().isBlank()) throw new BadRequestException("Name cannot be blank");
    }
}
