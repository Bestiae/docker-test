package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.GroupMemberDTO;
import com.capco.expensesapp.models.GroupMember;
import com.capco.expensesapp.services.GroupMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("group-member")
public class GroupMemberController {

    @Autowired
    private final GroupMemberService groupMemberService;

    public GroupMemberController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @GetMapping("/all")
    public List<GroupMemberDTO> getAllGroupMembers(){
        return groupMemberService.getAllGroupMembers();
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public GroupMemberDTO addGroupMember(@RequestBody GroupMemberDTO groupMemberDTO) {
        log.info("Adding group member -> groupMemberService.addGroupMember({});", groupMemberDTO);
        return groupMemberService.addGroupMember(groupMemberDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFriendById(@PathVariable(value = "id") @Min(value = 0, message = "Friends id must be more then 0") Long id) {
        log.info("Deleting by id -> groupMemberService.deleteGroupMemberById({});", id);
        groupMemberService.deleteGroupMemberById(id);
    }
}
