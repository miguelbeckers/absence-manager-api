package absencemanager.controller;

import absencemanager.model.dto.AbsenceDTO;
import absencemanager.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/absences")
public class AbsenceController {
    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloAbsence() {
        return ResponseEntity.ok().body("hello, the absence path is working!");
    }

    @GetMapping
    public ResponseEntity<List<AbsenceDTO>> getAllAbsences() {
        List<AbsenceDTO> absenceDTOs = absenceService.getAll();
        return ResponseEntity.ok().body(absenceDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbsenceDTO> getAbsenceById(@PathVariable Long id) {
        AbsenceDTO absenceDTO = absenceService.getById(id);
        return ResponseEntity.ok().body(absenceDTO);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<AbsenceDTO>> getAbsencesByUser(@PathVariable Long id) {
        List<AbsenceDTO> absenceDTOs = absenceService.getByUser(id);
        return ResponseEntity.ok().body(absenceDTOs);
    }

    @GetMapping("/crew/{id}")
    public ResponseEntity<List<AbsenceDTO>> getAbsencesByCrew(@PathVariable Long id) {
        List<AbsenceDTO> absenceDTOs = absenceService.getByCrew(id);
        return ResponseEntity.ok().body(absenceDTOs);
    }

    @PostMapping
    public ResponseEntity<AbsenceDTO> createAbsence(@RequestBody AbsenceDTO absenceDTO) {
        AbsenceDTO created = absenceService.add(absenceDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PostMapping("/many")
    public ResponseEntity<List<AbsenceDTO>> createManyAbsences(@RequestBody List<AbsenceDTO> absenceDTOs) {
        List<AbsenceDTO> created = absenceService.addMany(absenceDTOs);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.get(0).getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/confirm")
    public ResponseEntity<AbsenceDTO> confirmAbsence(
            @RequestParam Long absenceId, @RequestParam Long admitterId, @RequestParam String note
    ) {
        AbsenceDTO confirmed = absenceService.confirm(absenceId, admitterId, note);
        return ResponseEntity.ok().body(confirmed);
    }

    @PutMapping("/reject")
    public ResponseEntity<AbsenceDTO> rejectAbsence(
            @RequestParam Long absenceId, @RequestParam Long admitterId, @RequestParam String note
    ) {
        AbsenceDTO rejected = absenceService.reject(absenceId, admitterId, note);
        return ResponseEntity.ok().body(rejected);
    }

    @PutMapping("{id}")
    public ResponseEntity<AbsenceDTO> updateAbsence(@PathVariable("id") Long id, @RequestBody AbsenceDTO absenceDTO) {
        AbsenceDTO updated = absenceService.update(id, absenceDTO);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteAbsence(@PathVariable("id") Long id) {
        absenceService.delete(id);
        return ResponseEntity.ok().body(id);
    }
}
