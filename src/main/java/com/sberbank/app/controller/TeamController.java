package com.sberbank.app.controller;

import com.sberbank.app.dao.model.Team;
import com.sberbank.app.service.TeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @ApiOperation(value = "get all teams from DB")
    @GetMapping("/teams")
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Team> getTeam(@PathVariable("id") long id) {
        return teamService.findById(id);
    }

    @ApiOperation(value = "save team")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTeam(@RequestBody Team team) {
        teamService.save(team);
    }

    @ApiOperation(value = "update team by id")
    @PutMapping("/update")
    public Team update(@RequestBody Team team) {
        return teamService.update(team);
    }

    @ApiOperation(value = "delete team by id")
    @DeleteMapping("/delete/{id}")
    public void deleteTeam(@PathVariable("id") long id) {
        teamService.deleteById(id);
    }

}