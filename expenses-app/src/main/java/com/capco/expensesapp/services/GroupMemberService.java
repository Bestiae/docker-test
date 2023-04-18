package com.capco.expensesapp.services;

import com.capco.expensesapp.dtos.GroupMemberDTO;
import com.capco.expensesapp.exception.NotFoundException;
import com.capco.expensesapp.models.GroupMember;
import com.capco.expensesapp.repositories.GroupMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GroupMemberService {

    private final GroupMemberRepository groupMemberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GroupMemberService(GroupMemberRepository groupMemberRepository, ModelMapper modelMapper) {
        this.groupMemberRepository = groupMemberRepository;
        this.modelMapper = modelMapper;
    }

    public List<GroupMemberDTO> getAllGroupMembers(){
        log.info("groupMemberRepository.findAll();");
        return modelMapper.map(groupMemberRepository.findAll(), new TypeToken<List<GroupMemberDTO>>(){}.getType());
    }

    public GroupMemberDTO addGroupMember(GroupMemberDTO groupMemberDTO) {

        GroupMember groupMember = modelMapper.map(groupMemberDTO, GroupMember.class);
        GroupMember findGroupMember = groupMemberRepository.findGroupMemberByPerson(groupMember.getPerson());

        if(!groupMember.equals(findGroupMember)){
            log.info("Group member is not present in this table.\ngroupMemberRepository.save({});", groupMember);
            return modelMapper.map(groupMemberRepository.save(groupMember),GroupMemberDTO.class);
        } else {
            log.info("Group member is present in this table.");
            return null;
        }
    }

    public void deleteGroupMemberById(Long id) {
        log.info("groupMemberRepository.findById({})", id);
        GroupMember groupMember = groupMemberRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Group member is not present in the table with this id: " + id));
        log.info("groupMemberRepository.deleteGroupMemberById({});", groupMember.getId());
        groupMemberRepository.deleteGroupMemberById(groupMember.getId());
    }

}
