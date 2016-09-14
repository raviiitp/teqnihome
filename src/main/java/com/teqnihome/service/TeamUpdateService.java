package com.teqnihome.service;

import java.util.Map;
import java.util.Set;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.teqnihome.entity.TeamStructure;
import com.teqnihome.entity.TeamStructurePK;

@Named(value="TeamUpdateService")
public class TeamUpdateService {
	

	@Autowired
	private TeamStructureServiceImpl tss;
	
	public void updateTeamInfo(Map<String, Map<String, String>> teamInfo){
		
		Set<String> studentNames = teamInfo.keySet();
		
		for(String studentName : studentNames){
			Map<String, String> studentInfo = teamInfo.get(studentName);
			String teamId = studentInfo.get("teamId");
			String studentId = studentInfo.get("studentId");
			String teamName = studentInfo.get("teamName");
			tss.removeTeam(teamId, studentId);
			tss.addTeam(new TeamStructure(new TeamStructurePK(teamId, studentId), teamName, studentName));
		}
	}
}
