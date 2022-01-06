package absencemanager.utility.converter;

import absencemanager.model.dto.UserDTO;
import absencemanager.model.entity.Crew;
import absencemanager.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    public UserDTO objectToDTO(User user) {
        if (user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setType(user.getType());
        userDTO.setImage(user.getImage());
        userDTO.setCrewId(user.getCrew().getId());
        return userDTO;
    }

    public List<UserDTO> objectToDTO(List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(objectToDTO(user));
        }
        return userDTOS;
    }

    public User dtoToObject(UserDTO userDTO) {
        if (userDTO == null) return null;
        User user = new User();
        Crew crew = new Crew();
        crew.setId(userDTO.getCrewId());
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setType(userDTO.getType());
        user.setImage(userDTO.getImage());
        user.setCrew(crew);
        return user;
    }

    public List<User> dtoToObject(List<UserDTO> userDTOS) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            users.add(dtoToObject(userDTO));
        }
        return users;
    }
}
