package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.Cricketer;
import com.examly.springapp.DAO.CricketDAO;

public class CricketerServiceImpl implements CricketerService{

	private CricketDAO cricketDAO;

	public CricketerServiceImpl() {
	 this.cricketDAO = new CricketDAO();
	 }

	public List<Cricketer> getAllCricketer() {
		return cricketDAO.getAllCricketer();
	}

	public void addCricketer(Cricketer cricketer) {
		cricketDAO.addCricketer(cricketer);
	}
}
