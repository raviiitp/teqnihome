package com.teqnihome.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamStructurePK implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name="team_id")
    private String teamId;
    
    
    @Column(name="student_id")
    private String studentId;


	public TeamStructurePK() {
		super();
		this.teamId = UUID.randomUUID().toString();
		this.studentId = UUID.randomUUID().toString();
	}


	public TeamStructurePK(String teamId, String studentId) {
		super();
		this.teamId = teamId;
		this.studentId = studentId;
	}


	public String getTeamId() {
		return teamId;
	}


	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
