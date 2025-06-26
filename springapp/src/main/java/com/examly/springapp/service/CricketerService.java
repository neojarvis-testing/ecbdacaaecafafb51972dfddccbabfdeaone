package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.Cricketer;

public interface CricketerService {
	public List<Cricketer> getAllCricketer();
	public void addCricketer(Cricketer cricketer);
}
