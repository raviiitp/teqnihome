package com.teqnihome2.tableInit;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.teqnihome2.entity.TeamStructure;
import com.teqnihome2.entity.TeamStructurePK;
import com.teqnihome2.service.TeamStructureServiceImpl;

@Named(value="TableInitializer")
public class TableInitializer {
	
	@Inject
	private TeamStructureServiceImpl tss;
	
	@PostConstruct
	public void init(){
		List<TeamStructure> teamList = tss.listTeams();
		if(teamList != null && teamList.size() == 0){
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "Available Students", "StudentA"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "Available Students", "StudentB"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "Available Students", "StudentC"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "Available Students", "StudentD"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "Available Students", "StudentE"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "TeamA", "StudentF"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "TeamA", "StudentG"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "TeamB", "StudentH"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "TeamB", "StudentI"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "TeamC", "StudentJ"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "TeamC", "StudentK"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "TeamD", "StudentL"));
			
			tss.addTeam(new TeamStructure(new TeamStructurePK(), "TeamD", "StudentM"));
		}
	}
}
