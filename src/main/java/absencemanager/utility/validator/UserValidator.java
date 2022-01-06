package absencemanager.utility.validator;

import absencemanager.model.entity.Crew;
import absencemanager.model.entity.User;
import absencemanager.repository.CrewRepository;
import absencemanager.utility.exception.ApiExceptionConstants;
import absencemanager.utility.exception.BadRequestException;
import absencemanager.utility.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {
    private final CrewRepository crewRepository;

    @Autowired
    public UserValidator(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    public void validate(User user) {
        if (user.getName() == null) throw new BadRequestException("Name cannot be null");
        if (user.getName().isBlank()) throw new BadRequestException("Name cannot be blank");
        if (user.getType() == null) throw new BadRequestException("Type cannot be null");
        if (user.getImage() == null) throw new BadRequestException("Image cannot be null");
        if (user.getImage().isBlank()) throw new BadRequestException("Image cannot be blank");
        if (user.getCrew().getId() == null) throw new BadRequestException("CrewId cannot be null");

        Crew crew = crewRepository.findById(user.getCrew().getId()).orElse(null);
        if (crew == null) throw new NotFoundException(ApiExceptionConstants.CREW_NOT_FOUND);
    }
}
