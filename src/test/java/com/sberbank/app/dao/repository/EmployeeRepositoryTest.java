package com.sberbank.app.dao.repository;

import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.dao.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void successfullySaveNewEmployee() {
        Team team = new Team();
        team.setName("Name");
        team.setTag("Agile");
        team.setType("new");
        Team savedTeam = teamRepository.save(team);

        assertNotNull(savedTeam.getId());

        Employee employee = new Employee();
        employee.setAge(12);
        employee.setFirstName("123");
        employee.setGivenName("321");
        employee.setLastName("23rfewf");
        employee.setPosition("Java");
        employee.setTeam(savedTeam);

        Employee savedEmployee = employeeRepository.save(employee);

        assertNotNull(savedEmployee.getId());
    }


}