package com.teqnihome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="team_structure")
public class TeamStructure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private TeamStructurePK teamStructurePK;
	
	@Column(name="team_name")
	private String teamName;

	@Column(name="student_name")
	private String studentName;


	public TeamStructure() {
		super();
	}

	public TeamStructure(TeamStructurePK teamStructurePK, String teamName, String studentName) {
		super();
		this.teamStructurePK = teamStructurePK;
		this.teamName = teamName;
		this.studentName = studentName;
	}

	public TeamStructurePK getTeamStructurePK() {
		return teamStructurePK;
	}

	public void setTeamStructurePK(TeamStructurePK teamStructurePK) {
		this.teamStructurePK = teamStructurePK;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "TeamStructure [teamStructurePK=" + teamStructurePK + ", teamName=" + teamName + ", studentName=" + studentName + "]";
	}

}