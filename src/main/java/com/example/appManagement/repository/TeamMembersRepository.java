package com.example.appManagement.repository;

import com.example.appManagement.entity.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembers, Long> {
    @Query("SELECT tm FROM TeamMembers tm ORDER BY tm.cartonaseRosi DESC")
    List<TeamMembers> findTopByCartonaseRosi(int limit);
}
