package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.DTO.GrpMedDTO;
import com.test.Inoteqia.Entity.GroupeMed;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Services.GroupeMedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupeMed")
public class GroupeMedController {
    @Autowired
    GroupeMedService groupeMedService;
@DeleteMapping("/delete-groupeMed/{id}")
    public void deleteGroupeMed(@PathVariable Long id) {
        groupeMedService.deleteGroupeMed(id);
    }
@PostMapping("/add-groupeMed")
    public void addGroupeMed(@RequestBody GrpMedDTO groupeMed) {
        groupeMedService.addGroupeMed(groupeMed);
    }
@GetMapping("/get-groupeMed-by-id/{id}")
    public GroupeMed getGroupeMedById(@PathVariable Long id) {
        return groupeMedService.getGroupeMedById(id);
    }
@GetMapping("/list-groupeMed")
    public List<GroupeMed> getAllGroupeMed() {
       return groupeMedService.getAllGroupeMed();
    }
@GetMapping("/show-list-meds/{id}")
    public List<Medecin> showlistmeds(@PathVariable Long id) {
        return groupeMedService.showlistmeds(id);
    }
@PutMapping("/modifmed/{id}")
    public GroupeMed updateGroupeMed(@RequestBody GrpMedDTO groupeMed, @PathVariable Long id) {
        return groupeMedService.updateGroupeMed(groupeMed,id);
    }
}
