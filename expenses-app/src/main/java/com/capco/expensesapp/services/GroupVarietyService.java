package com.capco.expensesapp.services;

import com.capco.expensesapp.dtos.GroupVarietyDTO;
import com.capco.expensesapp.exception.NotFoundException;
import com.capco.expensesapp.models.GroupVariety;
import com.capco.expensesapp.repositories.GroupVarietyRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GroupVarietyService {

    private final GroupVarietyRepository groupVarietyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GroupVarietyService(GroupVarietyRepository groupVarietyRepository, ModelMapper modelMapper) {
        this.groupVarietyRepository = groupVarietyRepository;
        this.modelMapper = modelMapper;
    }

    public List<GroupVarietyDTO> getAllGroupVariety() {
        log.info("groupVarietyRepository.findAll();");
        return modelMapper.map(groupVarietyRepository.findAll(), new TypeToken<List<GroupVarietyDTO>>(){}.getType());
    }

    public GroupVarietyDTO addGroupVariety(GroupVarietyDTO groupVariety) {
        GroupVariety gv = modelMapper.map(groupVariety, GroupVariety.class);
        log.info("groupVarietyRepository.save(groupVariety);");
        return modelMapper.map(groupVarietyRepository.save(gv), GroupVarietyDTO.class);
    }

    public void deleteGroupVarietyById(Long id) {
        log.info("");
        GroupVariety g = groupVarietyRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Group by this id: " + id + " is not found."));
        groupVarietyRepository.delete(g);
    }

    public GroupVarietyDTO findGroupVarietyByName(String groupName) {
        log.info("Find group by name -> groupVarietyRepository.findGroupVarietyByGroupvar_name({});", groupName);
        return  modelMapper.map(groupVarietyRepository.findGroupVarietyByGroupvar_name(groupName),
                GroupVarietyDTO.class);
    }

    public GroupVarietyDTO updateGroupVariety(GroupVarietyDTO groupVarietyDTO) {
        GroupVariety groupVariety = modelMapper.map(groupVarietyDTO, GroupVariety.class);
        GroupVariety updateResponse = groupVarietyRepository.save(groupVariety);
        return modelMapper.map(updateResponse, GroupVarietyDTO.class);
    }
}
