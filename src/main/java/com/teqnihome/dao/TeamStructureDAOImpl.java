package com.teqnihome.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.teqnihome.entity.TeamStructure;
import com.teqnihome.entity.TeamStructurePK;

@Repository
public class TeamStructureDAOImpl implements TeamStructureDAO {

	private static final Logger logger = LoggerFactory.getLogger(TeamStructureDAOImpl.class);

	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addTeam(TeamStructure p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Team saved successfully, Team Details=" + p);
	}

	@Override
	public void updateTeam(TeamStructure p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Team updated successfully, Team Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamStructure> listTeams() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TeamStructure> teamList = session.createQuery("from TeamStructure ts").list();
		return teamList;
	}

	@Override
	public TeamStructure getTeamById(String teamID, String studentID) {
		Session session = this.sessionFactory.getCurrentSession();
		TeamStructure p = (TeamStructure) session.load(TeamStructure.class, new TeamStructurePK(teamID, studentID));
		logger.info("Team loaded successfully, Team details=" + p);
		return p;
	}

	@Override
	public void removeTeam(String teamID, String studentID) {
		Session session = this.sessionFactory.getCurrentSession();
		TeamStructure p = (TeamStructure) session.load(TeamStructure.class, new TeamStructurePK(teamID, studentID));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Team deleted successfully, Team details=" + p);
	}

}
