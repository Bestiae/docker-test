package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.GroupVarietyDTO;
import com.capco.expensesapp.models.GroupVariety;
import com.capco.expensesapp.services.GroupVarietyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("group")
public class GroupVarietyController {

    @Autowired
    private final GroupVarietyService groupVarietyService;

    public GroupVarietyController(GroupVarietyService groupVarietyService) {
        this.groupVarietyService = groupVarietyService;
    }

    @GetMapping("/all")
    public List<GroupVarietyDTO> getAllGroupVariety() {
        log.info("groupVarietyService.getAllGroupVariety();");
        return groupVarietyService.getAllGroupVariety();
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void addGroupVariety(@RequestBody GroupVarietyDTO groupVariety) {
        log.info("Creating groupVariety -> groupVarietyService.addGroupVariety({});", groupVariety);
        groupVarietyService.addGroupVariety(groupVariety);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroupVariaty(@PathVariable(value = "id") Long id) {
        log.info("Deleting groupVariety by id -> groupVarietyService.deleteGroupVarietyById({}});", id);
        groupVarietyService.deleteGroupVarietyById(id);
    }

    @GetMapping("/find/{name}")
    public GroupVarietyDTO findGroupVarietyByName(@PathVariable(value = "name") String name) {
        log.info("Find groupVariety by name -> groupVarietyService.findGroupVarietyByName({});", name);
        return groupVarietyService.findGroupVarietyByName(name);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public GroupVarietyDTO updateGroupVariety(@RequestBody GroupVarietyDTO groupVarietyDTO) {
        log.info("Updating group -> groupVarietyService.updateGroupVariety({});", groupVarietyDTO);
        return groupVarietyService.updateGroupVariety(groupVarietyDTO);
    }
}
