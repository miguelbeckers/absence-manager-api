package absencemanager.utility.converter;

import absencemanager.model.dto.CrewDTO;
import absencemanager.model.entity.Crew;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CrewConverter {
    public CrewDTO objectToDTO(Crew crew) {
        if (crew == null) return null;
        CrewDTO crewDTO = new CrewDTO();
        crewDTO.setId(crew.getId());
        crewDTO.setName(crew.getName());
        return crewDTO;
    }

    public List<CrewDTO> objectToDTO(List<Crew> crews) {
        List<CrewDTO> crewDTOs = new ArrayList<>();
        for (Crew crew : crews) {
            crewDTOs.add(objectToDTO(crew));
        }
        return crewDTOs;
    }

    public Crew dtoToObject(CrewDTO crewDTO) {
        if (crewDTO == null) return null;
        Crew crew = new Crew();
        crew.setId(crewDTO.getId());
        crew.setName(crewDTO.getName());
        return crew;
    }

    public List<Crew> dtoToObject(List<CrewDTO> crewDTOs) {
        List<Crew> crews = new ArrayList<>();
        for (CrewDTO crewDTO : crewDTOs) {
            crews.add(dtoToObject(crewDTO));
        }
        return crews;
    }
}
