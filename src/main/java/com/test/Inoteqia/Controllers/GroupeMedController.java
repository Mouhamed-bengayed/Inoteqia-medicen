package com.test.Inoteqia.Controllers;

import com.test.Inoteqia.Entity.GroupeMed;
import com.test.Inoteqia.Services.GroupeMedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groupeMed")
public class GroupeMedController {
    @Autowired
    GroupeMedService groupeMedService;
@DeleteMapping("/delete-groupeMed/{id}")
    public void deleteGroupeMed(Long id) {
        groupeMedService.deleteGroupeMed(id);
    }
@PostMapping("/add-groupeMed")
    public void addGroupeMed(GroupeMed groupeMed) {
        groupeMedService.addGroupeMed(groupeMed);
    }
@GetMapping("/get-groupeMed-by-id/{id}")
    public GroupeMed getGroupeMedById(Long id) {
        return groupeMedService.getGroupeMedById(id);
    }
@GetMapping("/list-groupeMed")
    public void getAllGroupeMed() {
        groupeMedService.getAllGroupeMed();
    }
}
