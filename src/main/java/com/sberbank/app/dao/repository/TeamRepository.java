package com.sberbank.app.dao.repository;

import com.sberbank.app.dao.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamByName(String name);

}
