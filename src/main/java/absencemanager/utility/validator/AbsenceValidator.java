package absencemanager.utility.validator;

import absencemanager.model.entity.Absence;
import absencemanager.model.entity.Crew;
import absencemanager.model.entity.User;
import absencemanager.repository.CrewRepository;
import absencemanager.repository.UserRepository;
import absencemanager.utility.exception.ApiExceptionConstants;
import absencemanager.utility.exception.BadRequestException;
import absencemanager.utility.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbsenceValidator {
    private final UserRepository userRepository;
    private final CrewRepository crewRepository;

    @Autowired
    public AbsenceValidator(UserRepository userRepository, CrewRepository crewRepository) {
        this.userRepository = userRepository;
        this.crewRepository = crewRepository;
    }

    public void validate(Absence absence) {
        if (absence.getUser().getId() == null) throw new BadRequestException("User cannot be null");
        if (absence.getCrew().getId() == null) throw new BadRequestException("Crew cannot be null");
        if (absence.getStartDate() == null) throw new BadRequestException("Start date cannot be null");
        if (absence.getEndDate() == null) throw new BadRequestException("End date cannot be null");
        if (absence.getType() == null) throw new BadRequestException("Type cannot be null");

        User user = userRepository.findById(absence.getUser().getId()).orElse(null);
        if (user == null) throw new NotFoundException(ApiExceptionConstants.USER_NOT_FOUND);
        Crew crew = crewRepository.findById(absence.getCrew().getId()).orElse(null);
        if (crew == null) throw new NotFoundException(ApiExceptionConstants.USER_NOT_FOUND);
    }
}
