package com.capco.expensesapp.services;

import com.capco.expensesapp.dtos.FriendDTO;
import com.capco.expensesapp.exception.NotFoundException;
import com.capco.expensesapp.models.Friend;
import com.capco.expensesapp.repositories.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FriendService {

    private final FriendRepository friendRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FriendService(FriendRepository friendRepository, ModelMapper modelMapper) {
        this.friendRepository = friendRepository;
        this.modelMapper = modelMapper;
    }

    public List<FriendDTO> getAllFriends() {
        log.info("friendRepository.findAll();");
        return modelMapper.map(friendRepository.findAll(), new TypeToken<List<FriendDTO>>(){}.getType());
    }

    public List<FriendDTO> findFriendsByPersonId(Long id) {
        log.info("friendRepository.findAllFriendsByFriendOneId({});", id);
        return modelMapper.map(friendRepository.findAllFriendsByPersonId(id), new TypeToken<List<FriendDTO>>(){}.getType());
    }

    public FriendDTO addFriend(FriendDTO friendDTO){
        log.info("friendRepository.save({});", friendDTO);
        Friend friend = modelMapper.map(friendDTO, Friend.class);
        friendRepository.save(friend);
        return modelMapper.map(friend, FriendDTO.class);
    }

    public void addFriend(Long friend_one, Long friend_two){
        log.info("friendRepository.addFriend({},{});", friend_one, friend_two);
        // make insert with repository.save();
        // create two objects of Person
        // find that persons by id
        // create new Friend where you will add that persons.
        // and make friendRepository.save() where I will add it to the db.

        friendRepository.addFriend(friend_one, friend_two);
    }

    public void deleteFriendById(Long id)  {
        log.info("Trying to find friend by Id - friendRepository.findById({}}).orElseThrow();", id);
        Friend friend = friendRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Friend with Id: " + id + " does not exist"));
        log.info("Deleting friend from table Friend - friendRepository.deleteFriendById({});", friend.getId());
        friendRepository.deleteFriendById(friend.getId());

    }

    public List<FriendDTO> findPersonFriendsById(Long id) {
        log.info("friendRepository.findPersonFriendsById(id);");
        return modelMapper.map(friendRepository.findPersonFriendsById(id), new TypeToken<List<FriendDTO>>() {}.getType());
    }
}
