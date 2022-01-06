package absencemanager.service;

import absencemanager.model.dto.CrewDTO;
import absencemanager.model.entity.Crew;
import absencemanager.repository.CrewRepository;
import absencemanager.utility.converter.CrewConverter;
import absencemanager.utility.exception.ApiExceptionConstants;
import absencemanager.utility.exception.NotFoundException;
import absencemanager.utility.validator.CrewValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrewService {
    private final CrewConverter crewConverter;
    private final CrewRepository crewRepository;
    private final CrewValidator crewValidator;

    @Autowired
    public CrewService(CrewConverter crewConverter, CrewRepository crewRepository, CrewValidator crewValidator) {
        this.crewConverter = crewConverter;
        this.crewRepository = crewRepository;
        this.crewValidator = crewValidator;
    }

    public List<CrewDTO> getAll() {
        List<Crew> crews = crewRepository.findAll();
        return crewConverter.objectToDTO(crews);
    }

    public CrewDTO getById(Long id) {
        Crew crew = crewRepository.findById(id).orElse(null);
        if (crew == null) throw new NotFoundException(ApiExceptionConstants.CREW_NOT_FOUND);
        return crewConverter.objectToDTO(crew);
    }

    public CrewDTO add(CrewDTO crewDTO) {
        Crew crew = crewConverter.dtoToObject(crewDTO);
        crewValidator.validate(crew);
        Crew created = create(crew);
        return crewConverter.objectToDTO(created);
    }

    private Crew create(Crew crew) {
        if (crew.getId() == null) {
            Crew last = crewRepository.findFirstByOrderByIdDesc();
            long id = last != null ? last.getId() : 0;
            crew.setId(++id);
        }

        return crewRepository.save(crew);
    }

    public List<CrewDTO> addMany(List<CrewDTO> crewDTOs) {
        List<Crew> crews = crewConverter.dtoToObject(crewDTOs);
        for (Crew crew : crews) crewValidator.validate(crew);
        List<Crew> created = new ArrayList<>();
        for (Crew crew : crews) created.add(create(crew));
        return crewConverter.objectToDTO(created);
    }

    public CrewDTO update(Long id, CrewDTO crewDTO) {
        Crew old = crewRepository.findById(id).orElse(null);
        if (old == null) throw new NotFoundException(ApiExceptionConstants.CREW_NOT_FOUND);
        if (!crewDTO.getName().isBlank()) old.setName(crewDTO.getName());

        Crew updated = crewRepository.save(old);
        return crewConverter.objectToDTO(updated);
    }

    public void delete(Long id) {
        Crew crew = crewRepository.findById(id).orElse(null);
        if (crew == null) throw new NotFoundException(ApiExceptionConstants.CREW_NOT_FOUND);
        crewRepository.delete(crew);
    }
}
