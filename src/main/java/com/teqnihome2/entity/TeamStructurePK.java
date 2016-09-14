package com.teqnihome2.entity;

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamStructurePK other = (TeamStructurePK) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
	
}
