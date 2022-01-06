package absencemanager.service;

import absencemanager.model.dto.UserDTO;
import absencemanager.model.entity.Crew;
import absencemanager.model.entity.User;
import absencemanager.repository.CrewRepository;
import absencemanager.repository.UserRepository;
import absencemanager.utility.converter.UserConverter;
import absencemanager.utility.exception.ApiExceptionConstants;
import absencemanager.utility.exception.NotFoundException;
import absencemanager.utility.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserConverter userConverter;
    private final UserValidator userValidator;
    private final UserRepository userRepository;
    private final CrewRepository crewRepository;

    @Autowired
    public UserService(
            UserConverter userConverter,
            UserValidator userValidator,
            UserRepository userRepository,
            CrewRepository crewRepository

    ) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.crewRepository = crewRepository;
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return userConverter.objectToDTO(users);
    }

    public UserDTO getById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) throw new NotFoundException(ApiExceptionConstants.USER_NOT_FOUND);
        return userConverter.objectToDTO(user);
    }

    public List<UserDTO> getByCrew(Long id) {
        Crew crew = crewRepository.findById(id).orElse(null);
        if (crew == null) throw new NotFoundException(ApiExceptionConstants.CREW_NOT_FOUND);
        return userConverter.objectToDTO(crew.getUsers());
    }

    public UserDTO add(UserDTO userDTO) {
        User user = userConverter.dtoToObject(userDTO);
        userValidator.validate(user);

        User created = create(user);
        return userConverter.objectToDTO(created);
    }

    private User create(User user) {
        if (user.getId() == null) {
            User last = userRepository.findFirstByOrderByIdDesc();
            long id = last != null ? last.getId() : 0;
            user.setId(++id);
        }

        User created = userRepository.save(user);
        Crew crew = crewRepository.getById(user.getCrew().getId());
        crew.insertUser(created);
        crewRepository.save(crew);
        return created;
    }

    public List<UserDTO> addMany(List<UserDTO> userDTOS) {
        List<User> users = userConverter.dtoToObject(userDTOS);
        for (User user : users) userValidator.validate(user);
        List<User> created = new ArrayList<>();
        for (User user : users) created.add(create(user));
        return userConverter.objectToDTO(created);
    }

    public UserDTO update(Long id, UserDTO userDTO) {
        User old = userRepository.findById(id).orElse(null);
        if (old == null) throw new NotFoundException(ApiExceptionConstants.USER_NOT_FOUND);
        if (!userDTO.getName().isBlank()) old.setName(userDTO.getName());

        User updated = userRepository.save(old);
        return userConverter.objectToDTO(updated);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) throw new NotFoundException(ApiExceptionConstants.USER_NOT_FOUND);
        Crew crew = user.getCrew();
        crew.removeUser(user);
        crewRepository.save(crew);
        userRepository.delete(user);
    }
}
