package com.teqnihome2.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teqnihome2.dao.TeamStructureDAOImpl;
import com.teqnihome2.entity.TeamStructure;

@Service
public class TeamStructureServiceImpl implements TeamStructureService {
	
	@Inject
	private TeamStructureDAOImpl teamStructureDAOImpl;

	public void setTeamStructureDAO(TeamStructureDAOImpl teamStructureDAOImpl) {
		this.teamStructureDAOImpl = teamStructureDAOImpl;
	}

	@Override
	@Transactional
	public void addTeam(TeamStructure p) {
		this.teamStructureDAOImpl.addTeam(p);		
	}

	@Override
	@Transactional
	public void updateTeam(TeamStructure p) {
		this.teamStructureDAOImpl.updateTeam(p);		
	}

	@Override
	@Transactional
	public List<TeamStructure> listTeams() {
		return this.teamStructureDAOImpl.listTeams();
	}

	@Override
	@Transactional
	public TeamStructure getTeamById(String teamID, String studentID) {
		return this.teamStructureDAOImpl.getTeamById(teamID, studentID);
	}

	@Override
	@Transactional
	public void removeTeam(String teamID, String studentID) {
		this.teamStructureDAOImpl.removeTeam(teamID, studentID);		
	}
}
