package com.example.appManagement;

import com.example.appManagement.entity.TeamMembers;
import com.example.appManagement.repository.TeamMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppManagementApplication.class, args);
	}

	@Autowired
	private TeamMembersRepository teamMembersRepository;

	@Override
	public void run(String[] args) throws Exception{
		//add some player for begin
		/*TeamMembers teamMembers1 = new TeamMembers("Andrei", "Rus", 23, "roman", "fundas", 2,
				4, 200, 3, 1);
		teamMembersRepository.save(teamMembers1);

		TeamMembers teamMembers2 = new TeamMembers("George", "Bucur", 29, "roman", "portar", 0,
				0, 400, 1, 0);
		teamMembersRepository.save(teamMembers2);

		 */
	}
}
