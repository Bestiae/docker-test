package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.FriendDTO;
import com.capco.expensesapp.dtos.PersonDTO;
import com.capco.expensesapp.models.Friend;
import com.capco.expensesapp.services.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("friend")
public class FriendController {

    @Autowired
    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/all")
    public List<FriendDTO> getAllFriend() {
        log.info("friendService.getAllFriends();");
        List<FriendDTO> all = friendService.getAllFriends();
        log.info("Number of all Friends in DB - {}", all.size());
        return all;
    }

    @GetMapping("/find/{id}")
    public List<FriendDTO> findAllFriendsByPersonId(@PathVariable(value = "id") Long id) {
        log.info("friendService.findFriendsById({});", id);
        return friendService.findFriendsByPersonId(id);
    }

    @PostMapping(value = "/add", consumes = "application/json",produces = "application/json")
    public FriendDTO addFriend(@RequestBody FriendDTO friend) {
        log.info("friendService.addFriend({});", friend);
        return friendService.addFriend(friend);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFriendById(@PathVariable(value = "id") Long id) {
        log.info("friendService.deleteFriendById({});", id);
        friendService.deleteFriendById(id);
    }

    @GetMapping("/get-friends/{id}")
    public List<FriendDTO> findPersonFriendsById(@PathVariable(value = "id") Long id) {
        log.info("friendService.findPersonFriendsById(id);");
        return friendService.findPersonFriendsById(id);
    }

    @PostMapping("/add")
    public void addFriend(@RequestParam Long friend_one, @RequestParam Long friend_two) {
        log.info("Adding friend -> friendService.ddFriend( {}, {});", friend_one, friend_two);
        friendService.addFriend(friend_one, friend_two);
    }
}
