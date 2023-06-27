package com.example.appManagement.services;


import com.example.appManagement.entity.TeamMembers;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public interface TeamMembersService {
    List<TeamMembers> getAllTeamMembers();

    TeamMembers saveTeamMembers(TeamMembers teamMembers);

    TeamMembers getTeamMembersById(Long id);

    TeamMembers updateTeamMember(TeamMembers teamMembers);

    void deleteTeamMembersById(Long id);

    List<TeamMembers> getTopCartonaseRosi(int limit);

}
