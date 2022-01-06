package absencemanager.utility.converter;

import absencemanager.model.dto.AbsenceDTO;
import absencemanager.model.entity.Absence;
import absencemanager.model.entity.Crew;
import absencemanager.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AbsenceConverter {
    public AbsenceDTO objectToDTO(Absence absence) {
        if (absence == null) return null;
        AbsenceDTO absenceDTO = new AbsenceDTO();
        absenceDTO.setId(absence.getId());
        absenceDTO.setCrewId(absence.getCrew().getId());
        absenceDTO.setUserId(absence.getUser().getId());
        absenceDTO.setCreatedAt(absence.getCreatedAt());
        absenceDTO.setConfirmedAt(absence.getConfirmedAt());
        absenceDTO.setRejectedAt(absence.getRejectedAt());
        absenceDTO.setStartDate(absence.getStartDate());
        absenceDTO.setEndDate(absence.getEndDate());
        absenceDTO.setType(absence.getType());
        absenceDTO.setAdmitterNote(absence.getAdmitterNote());
        absenceDTO.setMemberNote(absence.getMemberNote());
        if (absence.getAdmitter() != null) {
            absenceDTO.setAdmitterId(absence.getAdmitter().getId());
        }
        return absenceDTO;
    }

    public List<AbsenceDTO> objectToDTO(List<Absence> absences) {
        List<AbsenceDTO> absenceDTOs = new ArrayList<>();
        for (Absence absence : absences) {
            absenceDTOs.add(objectToDTO(absence));
        }
        return absenceDTOs;
    }

    public Absence dtoToObject(AbsenceDTO absenceDTO) {
        if (absenceDTO == null) return null;
        Crew crew = new Crew();
        crew.setId(absenceDTO.getCrewId());
        User user = new User();
        user.setId(absenceDTO.getUserId());
        Absence absence = new Absence();
        User admitter = new User();
        if (absenceDTO.getAdmitterId() != null) {
            admitter.setId(absenceDTO.getAdmitterId());
            absence.setAdmitter(admitter);
        }

        absence.setId(absenceDTO.getId());
        absence.setCrew(crew);
        absence.setUser(user);
        absence.setConfirmedAt(absenceDTO.getConfirmedAt());
        absence.setRejectedAt(absenceDTO.getRejectedAt());
        absence.setStartDate(absenceDTO.getStartDate());
        absence.setEndDate(absenceDTO.getEndDate());
        absence.setType(absenceDTO.getType());
        absence.setAdmitterNote(absenceDTO.getAdmitterNote());
        absence.setMemberNote(absenceDTO.getMemberNote());
        return absence;
    }

    public List<Absence> dtoToObject(List<AbsenceDTO> absenceDTOs) {
        List<Absence> absences = new ArrayList<>();
        for (AbsenceDTO absenceDTO : absenceDTOs) {
            absences.add(dtoToObject(absenceDTO));
        }
        return absences;
    }
}
