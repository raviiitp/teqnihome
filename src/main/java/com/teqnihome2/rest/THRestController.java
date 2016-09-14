package com.teqnihome2.rest;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teqnihome2.entity.TeamStructure;
import com.teqnihome2.service.TeamStructureServiceImpl;
import com.teqnihome2.service.TeamUpdateService;

@RestController
public class THRestController {
	
	@Inject
	private TeamStructureServiceImpl tss;
	
	@Inject
	private TeamUpdateService teamUpdateService;
	
	@PostConstruct
	public void init(){
	}

	@RequestMapping(value = "/updateTeamStructure", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateQueries(@RequestBody(required = true) Map<String, Map<String, String>> teamInfo, HttpServletRequest request) {

		teamUpdateService.updateTeamInfo(teamInfo);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getTeamInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchQueries(HttpServletRequest request) {

		List<TeamStructure> teamList = tss.listTeams();
		return new ResponseEntity<>(teamList, HttpStatus.OK);
	}

}
