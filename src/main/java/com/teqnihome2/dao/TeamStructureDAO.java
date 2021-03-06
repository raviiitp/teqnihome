package com.teqnihome2.dao;

import java.util.List;

import com.teqnihome2.entity.TeamStructure;

public interface TeamStructureDAO {
	public void addTeam(TeamStructure p);
	public void updateTeam(TeamStructure p);
	public List<TeamStructure> listTeams();
	public TeamStructure getTeamById(String teamID, String studentID);
	public void removeTeam(String teamID, String studentID);
}
