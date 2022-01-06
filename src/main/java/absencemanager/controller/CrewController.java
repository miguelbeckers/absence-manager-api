package absencemanager.controller;


import absencemanager.model.dto.CrewDTO;
import absencemanager.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/crews")
public class CrewController {
    private final CrewService crewService;

    @Autowired
    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloCrew() {
        return ResponseEntity.ok().body("hello, the crew path is working!");
    }

    @GetMapping
    public ResponseEntity<List<CrewDTO>> getAllCrews() {
        List<CrewDTO> crewDTOs = crewService.getAll();
        return ResponseEntity.ok().body(crewDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewDTO> getCrewById(@PathVariable Long id) {
        CrewDTO crewDTO = crewService.getById(id);
        return ResponseEntity.ok().body(crewDTO);
    }

    @PostMapping
    public ResponseEntity<CrewDTO> createCrew(@RequestBody CrewDTO crewDTO) {
        CrewDTO created = crewService.add(crewDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PostMapping("/many")
    public ResponseEntity<List<CrewDTO>> createManyCrews(@RequestBody List<CrewDTO> crewDTOs) {
        List<CrewDTO> created = crewService.addMany(crewDTOs);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.get(0).getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("{id}")
    public ResponseEntity<CrewDTO> updateCrew(@PathVariable("id") Long id, @RequestBody CrewDTO crewDTO) {
        CrewDTO updated = crewService.update(id, crewDTO);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteCrew(@PathVariable("id") Long id) {
        crewService.delete(id);
        return ResponseEntity.ok().body(id);
    }
}
