package com.example.appManagement.controller;


import com.example.appManagement.entity.TeamMembers;
import com.example.appManagement.exporter.PDFExporter;
import com.example.appManagement.repository.TeamMembersRepository;
import com.example.appManagement.services.TeamMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import java.util.List;

@Controller
public class TeamMembersController {
    private TeamMembersService teamMembersService;

    public TeamMembersController(TeamMembersService teamMembersService) {
        super();
        this.teamMembersService = teamMembersService;
    }

    @GetMapping("/teamMembers")
    public String listTeamMembers(Model model){
        model.addAttribute("teamMembers", teamMembersService.getAllTeamMembers());
        return "teamMembers";
    }

    @GetMapping("/teamMembers/new")
    public String createNewTeamMember(Model model){
        //create student object to hold student form data
        TeamMembers teamMember = new TeamMembers();
        model.addAttribute("teamMember", teamMember);
        return "create_teamMember";
    }

    @PostMapping("/teamMembers")
    public String saveTeamMembers(@ModelAttribute("teamMembers") TeamMembers teamMembers){
        teamMembersService.saveTeamMembers(teamMembers);
        return "redirect:/teamMembers";
    }

    @GetMapping("teamMembers/edit/{id}")
    public String editTeamMembersForm(@PathVariable Long id, Model model){
        model.addAttribute("teamMember", teamMembersService.getTeamMembersById(id));
        return "edit_teamMember";
    }

    @PostMapping("/teamMembers/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("teamMember") TeamMembers teamMembers, Model model){
        TeamMembers existInTeamMember = teamMembersService.getTeamMembersById(id);
        existInTeamMember.setName(teamMembers.getName());
        existInTeamMember.setSurname(teamMembers.getSurname());
        existInTeamMember.setVarsta(teamMembers.getVarsta());
        existInTeamMember.setNationalitate(teamMembers.getNationalitate());
        existInTeamMember.setPozitie(teamMembers.getPozitie());
        existInTeamMember.setGoluri(teamMembers.getGoluri());
        existInTeamMember.setPaseDecisive(teamMembers.getPaseDecisive());
        existInTeamMember.setMinuteJucate(teamMembers.getMinuteJucate());
        existInTeamMember.setCartonaseGalbene(teamMembers.getCartonaseGalbene());
        existInTeamMember.setCartonaseRosi(teamMembers.getCartonaseRosi());

        teamMembersService.updateTeamMember(existInTeamMember);
        return "redirect:/teamMembers";
    }

    @GetMapping("/teamMembers/{id}")
    public String deleteTeamMember(@PathVariable Long id){
        teamMembersService.deleteTeamMembersById(id);
        return "redirect:/teamMembers";
    }

    @GetMapping("/teamMembers/redCards")
    public String getTopRedCardPlayers(Model model) {
        List<TeamMembers> teamMembers = teamMembersService.getTopCartonaseRosi(10); // Afișăm top 10 jucători
        model.addAttribute("teamMembers", teamMembers);
        return "top_players_by_red_cards";
    }

    @Autowired
    private TeamMembersRepository teamMembersRepository;
    
    @RequestMapping(name = "teamMembers/export-pdf", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> teamMembersPDFExporter() throws IOException {

        List<TeamMembers> teamMembersList = teamMembersRepository.findAll();

        ByteArrayInputStream bis = PDFExporter.teamMembersPDFExporter(teamMembersList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=team-members.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
