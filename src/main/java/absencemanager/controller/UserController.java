package absencemanager.controller;

import absencemanager.model.dto.UserDTO;
import absencemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloUser() {
        return ResponseEntity.ok().body("hello, the user path is working!");
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOS = userService.getAll();
        return ResponseEntity.ok().body(userDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getById(id);
        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping("/crew/{id}")
    public ResponseEntity<List<UserDTO>> getUsersByCrew(@PathVariable Long id) {
        List<UserDTO> userDTOS = userService.getByCrew(id);
        return ResponseEntity.ok().body(userDTOS);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO created = userService.add(userDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PostMapping("/many")
    public ResponseEntity<List<UserDTO>> createManyUsers(@RequestBody List<UserDTO> userDTOS) {
        List<UserDTO> created = userService.addMany(userDTOS);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.get(0).getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        UserDTO updated = userService.update(id, userDTO);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().body(id);
    }
}
