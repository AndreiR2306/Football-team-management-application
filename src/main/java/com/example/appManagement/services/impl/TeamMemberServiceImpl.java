package com.example.appManagement.services.impl;

import com.example.appManagement.entity.TeamMembers;
import com.example.appManagement.repository.TeamMembersRepository;
import com.example.appManagement.services.TeamMembersService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TeamMemberServiceImpl implements TeamMembersService {
    private TeamMembersRepository teamMembersRepository;

    public TeamMemberServiceImpl(TeamMembersRepository teamMembersRepository) {
        super();
        this.teamMembersRepository = teamMembersRepository;
    }

    @Override
    public List<TeamMembers> getAllTeamMembers(){
        return teamMembersRepository.findAll();
    }

    @Override
    public TeamMembers saveTeamMembers(TeamMembers teamMembers){
        return teamMembersRepository.save(teamMembers);
    }

    @Override
    public TeamMembers getTeamMembersById(Long id) {
        return teamMembersRepository.findById(id).get();
    }

    @Override
    public TeamMembers updateTeamMember(TeamMembers teamMembers) {
        return teamMembersRepository.save(teamMembers);
    }

    @Override
    public void deleteTeamMembersById(Long id) {
        teamMembersRepository.deleteById(id);
    }

    @Override
    public List<TeamMembers> getTopCartonaseRosi(int limit) {
        return teamMembersRepository.findTopByCartonaseRosi(limit);
    }
}
