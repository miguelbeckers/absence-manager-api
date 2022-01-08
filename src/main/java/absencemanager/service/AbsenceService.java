package absencemanager.service;

import absencemanager.model.dto.AbsenceDTO;
import absencemanager.model.entity.Absence;
import absencemanager.model.entity.Crew;
import absencemanager.model.entity.User;
import absencemanager.model.enumerator.UserType;
import absencemanager.repository.AbsenceRepository;
import absencemanager.repository.CrewRepository;
import absencemanager.repository.UserRepository;
import absencemanager.utility.converter.AbsenceConverter;
import absencemanager.utility.exception.ApiExceptionConstants;
import absencemanager.utility.exception.BadRequestException;
import absencemanager.utility.exception.NotFoundException;
import absencemanager.utility.validator.AbsenceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbsenceService {
    private final AbsenceConverter absenceConverter;
    private final AbsenceValidator absenceValidator;
    private final AbsenceRepository absenceRepository;
    private final UserRepository userRepository;
    private final CrewRepository crewRepository;


    @Autowired
    public AbsenceService(
            AbsenceConverter absenceConverter,
            AbsenceValidator absenceValidator,
            AbsenceRepository absenceRepository,
            UserRepository userRepository,
            CrewRepository crewRepository

    ) {
        this.absenceConverter = absenceConverter;
        this.absenceValidator = absenceValidator;
        this.absenceRepository = absenceRepository;
        this.userRepository = userRepository;
        this.crewRepository = crewRepository;
    }

    public List<AbsenceDTO> getAll() {
        List<Absence> absences = absenceRepository.findAll();
        return absenceConverter.objectToDTO(absences);
    }

    public AbsenceDTO getById(Long id) {
        Absence absence = absenceRepository.findById(id).orElse(null);
        if (absence == null) throw new NotFoundException(ApiExceptionConstants.ABSENCE_NOT_FOUND);
        return absenceConverter.objectToDTO(absence);
    }

    public List<AbsenceDTO> getByUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) throw new NotFoundException(ApiExceptionConstants.USER_NOT_FOUND);
        return absenceConverter.objectToDTO(user.getAbsences());
    }

    public List<AbsenceDTO> getByCrew(Long id) {
        Crew crew = crewRepository.findById(id).orElse(null);
        if (crew == null) throw new NotFoundException(ApiExceptionConstants.CREW_NOT_FOUND);
        return absenceConverter.objectToDTO(crew.getAbsences());
    }

    public AbsenceDTO add(AbsenceDTO absenceDTO) {
        Absence absence = absenceConverter.dtoToObject(absenceDTO);
        absenceValidator.validate(absence);
        return absenceConverter.objectToDTO(create(absence));
    }

    private Absence create(Absence absence) {
        if (absence.getId() == null) {
            Absence last = absenceRepository.findFirstByOrderByIdDesc();
            long id = last != null ? last.getId() : 0;
            absence.setId(++id);
        }

        absence.setCreatedAt(java.time.ZonedDateTime.now());
        Absence created = absenceRepository.save(absence);

        User user = userRepository.getById(absence.getUser().getId());
        user.insertAbsence(created);
        userRepository.save(user);

        Crew crew = crewRepository.getById(absence.getCrew().getId());
        crew.insertAbsence(created);
        crewRepository.save(crew);
        return created;
    }

    public List<AbsenceDTO> addMany(List<AbsenceDTO> absenceDTOs) {
        List<Absence> absences = absenceConverter.dtoToObject(absenceDTOs);
        for (Absence absence : absences) absenceValidator.validate(absence);

        List<Absence> created = new ArrayList<>();
        for (Absence absence : absences) created.add(create(absence));
        return absenceConverter.objectToDTO(created);
    }

    public AbsenceDTO confirm(Long absenceId, Long admitterId, String note) {
        Absence absence = absenceRepository.findById(absenceId).orElse(null);
        if (absence == null) throw new NotFoundException(ApiExceptionConstants.ABSENCE_NOT_FOUND);
        User admitter = userRepository.findById(admitterId).orElse(null);
        if (admitter == null) throw new NotFoundException(ApiExceptionConstants.ADMITTER_NOT_FOUND);

        if (admitter.getType() != UserType.ADMITTER) throw new BadRequestException("User not allowed to admit");

        absence.setAdmitter(admitter);
        absence.setAdmitterNote(note);
        absence.setConfirmedAt(java.time.ZonedDateTime.now());
        absence.setRejectedAt(null);
        Absence confirmed = absenceRepository.save(absence);
        return absenceConverter.objectToDTO(confirmed);
    }

    public AbsenceDTO reject(Long absenceId, Long admitterId, String note) {
        User admitter = userRepository.findById(admitterId).orElse(null);
        if (admitter == null) throw new NotFoundException(ApiExceptionConstants.ADMITTER_NOT_FOUND);
        Absence absence = absenceRepository.findById(absenceId).orElse(null);
        if (absence == null) throw new NotFoundException(ApiExceptionConstants.ABSENCE_NOT_FOUND);

        if (admitter.getType() != UserType.ADMITTER) throw new BadRequestException("User not allowed to reject");

        absence.setAdmitter(admitter);
        absence.setAdmitterNote(note);
        absence.setRejectedAt(java.time.ZonedDateTime.now());
        absence.setConfirmedAt(null);
        Absence rejected = absenceRepository.save(absence);
        return absenceConverter.objectToDTO(rejected);
    }

    public AbsenceDTO update(Long id, AbsenceDTO absenceDTO) {
        Absence old = absenceRepository.findById(id).orElse(null);
        if (old == null) throw new NotFoundException(ApiExceptionConstants.ABSENCE_NOT_FOUND);

        if (absenceDTO.getCrewId() != null) {
            Crew crew = crewRepository.findById(absenceDTO.getCrewId()).orElse(null);
            if (crew == null) throw new NotFoundException(ApiExceptionConstants.CREW_NOT_FOUND);
            old.setCrew(crew);
        }

        if (absenceDTO.getUserId() != null) {
            User user = userRepository.findById(absenceDTO.getUserId()).orElse(null);
            if (user == null) throw new NotFoundException(ApiExceptionConstants.USER_NOT_FOUND);
            old.setUser(user);
        }

        if (absenceDTO.getStartDate() != null) old.setStartDate(absenceDTO.getStartDate());
        if (absenceDTO.getEndDate() != null) old.setEndDate(absenceDTO.getEndDate());
        if (absenceDTO.getType() != null) old.setType(absenceDTO.getType());
        if (absenceDTO.getMemberNote() != null) old.setMemberNote(absenceDTO.getMemberNote());

        Absence updated = absenceRepository.save(old);
        return absenceConverter.objectToDTO(updated);
    }

    public void delete(Long id) {
        Absence absence = absenceRepository.findById(id).orElse(null);
        if (absence == null) throw new NotFoundException(ApiExceptionConstants.ABSENCE_NOT_FOUND);

        Crew crew = absence.getCrew();
        crew.removeAbsence(absence);
        crewRepository.save(crew);

        User user = absence.getUser();
        user.removeAbsence(absence);
        userRepository.save(user);

        absenceRepository.deleteById(id);
    }
}
