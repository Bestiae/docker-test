package com.capco.expensesapp.repositories;

import com.capco.expensesapp.models.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

    @Query(value = "SELECT * FROM friend f where f.friend_one = ?1 or f.friend_two = ?1", nativeQuery = true)
    List<Friend> findAllFriendsByPersonId(Long id);

    @Query(value = "select f.* " +
            "from  Person p " +
            "join Friend f on (f.friend_two = p.id or f.friend_one = p.id) " +
            "where (f.friend_one = ?1 or f.friend_two = ?1) and not p.id = ?1", nativeQuery = true)
    List<Friend> findPersonFriendsById(Long id);

    @Modifying
    @Query(value = "Delete from Friend f Where f.Id = ?1", nativeQuery = true)
    void deleteFriendById(Long id);

    @Modifying
    @Query(value = "insert into Friend(friend_one, friend_two, expenses_id) values (?1, ?2, null);", nativeQuery = true)
    void addFriend(Long friend_one, Long friend_two);
}
