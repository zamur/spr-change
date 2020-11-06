package com.sberbank.app.service;

import com.google.common.collect.Lists;
import com.sberbank.app.dao.model.Team;
import com.sberbank.app.dao.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public void save(Team team) {
        logger.info("Save Team to DB: {}", team);
        teamRepository.save(team);
    }

    public List<Team> findAll() {
        List<Team> employees = Lists.newArrayList(teamRepository.findAll());
        logger.info("Get Teams from DB: {}", employees);
        return teamRepository.findAll();
    }

    public Optional<Team> findById(long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        logger.info("Get Team by id from DB: {}", teamOptional);
        return teamRepository.findById(id);
    }

    public void deleteById(long id) {
        logger.info("Delete Team by id from DB: {}", id);
        teamRepository.deleteById(id);
    }

    @Transactional
    public Team update(Team team) {
        Optional<Team> optional = teamRepository.findById(team.getId());
        if (optional.isPresent()) {
            Team teamFromDb = optional.get();
            teamFromDb.setId(team.getId());
            teamFromDb.setName(team.getName());
            teamFromDb.setTag(team.getTag());
            teamFromDb.setType(team.getType());
            logger.info("Update Team in DB: {}", team);
            return teamRepository.save(teamFromDb);
        } else {
            throw new RuntimeException("Team with id: " + team.getId() + " not found");
        }
    }
}
