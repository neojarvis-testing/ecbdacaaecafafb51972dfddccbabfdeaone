package com.examly.springapp.service;
import java.util.List;

import com.examly.springapp.Teams;
import com.examly.springapp.DAO.TeamDAO;

public class TeamsService{

	private TeamDAO teamDao;
	
	public TeamsService() {
		 this.teamDao = new TeamDAO();
		 }

	public List<Teams> getAllTeams() {
		return teamDao.getAllTeams();
	}

	public void addTeams(Teams team) {
		teamDao.addTeam(team);
	}
	
	public void getCricketerWithTeam()
	{
		teamDao.getCricketerWithTeam();
	}
}
