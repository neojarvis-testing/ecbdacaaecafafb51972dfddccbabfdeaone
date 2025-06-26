package com.examly.springapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examly.springapp.service.CricketerServiceImpl;
import com.examly.springapp.service.TeamsService;


@SpringBootApplication
public class SpringappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringappApplication.class, args);

   
        addCricketers();
        displayCricketersFromDB();
        sortCricketers();
        displayTeamsFromDB();
        retrieveDataFromBothTables();
    
    }

    public static boolean sortCricketers() {
        CricketerServiceImpl cricketerService = new CricketerServiceImpl();
        try
        {

        ArrayList<Cricketer> cricketersList = new ArrayList<>();

        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 35, "New Zealand"));
        cricketersList.add(new Cricketer("MS Dhoni", 30, "India"));

        // Add more cricketers as needed

        // Sort by name using Comparable
        Collections.sort(cricketersList);

        // For JDBC CONNECTION TO SAVE DATA IN DB
        for (Cricketer c : cricketersList) {
            cricketerService.addCricketer(c);
        }
    

        // Print the cricketers sorted by name
        System.out.println("Cricketers sorted by name:");
        for (Cricketer cricketer : cricketersList) {
            System.out.println("Name: " + cricketer.getName() +
                    ", Age: " + cricketer.getAge() +
                    ", Country: " + cricketer.getCountry());
        }

        // Sort by age using Comparator
        Collections.sort(cricketersList, new CricketerAgeComparator());

        // Print the cricketers sorted by age
        System.out.println("Cricketers sorted by age:");
        for (Cricketer cricketer : cricketersList) {
            System.out.println("Name: " + cricketer.getName() +
                    ", Age: " + cricketer.getAge() +
                    ", Country: " + cricketer.getCountry());
        }

        return true;
    }catch(Exception e)
    {
        return false;
    }
    }

    public static void displayCricketersFromDB() {


        CricketerServiceImpl cricketerService = new CricketerServiceImpl();

        // For JDBC CONNECTION TO GET DATA FROM DB
        System.out.println("Display the Cricketers Details From DB");
        List<Cricketer> cricketerListDB = cricketerService.getAllCricketer();

        for (Cricketer cricketer : cricketerListDB) {
            System.out.println("Name: " + cricketer.getName() +
                    ", Age: " + cricketer.getAge() +
                    ", Country: " + cricketer.getCountry());
        }
    }

    public static void addCricketers() {
        TeamsService ts = new TeamsService();

        ArrayList<Teams> teamList = new ArrayList<>();

        teamList.add(new Teams("Senior Team", "India"));
        teamList.add(new Teams("Junior Team", "Australia"));
        teamList.add(new Teams("Senior Team", "New Zealand"));

        // For JDBC CONNECTION TO SAVE DATA IN DB
        for (Teams t : teamList) {
            ts.addTeams(t);
        }

        // Print the teams
        System.out.println("Teams added:");
        for (Teams t : teamList) {
            System.out.println("Name: " + t.getName() +
                    ", Country: " + t.getCountry());
        }
    }

    public static void displayTeamsFromDB() {
        TeamsService ts = new TeamsService();

        // For JDBC CONNECTION TO GET DATA FROM DB
        System.out.println("Display the Team Details From DB");
        List<Teams> teamListDB = ts.getAllTeams();

        for (Teams t : teamListDB) {
            System.out.println("Name: " + t.getName() +
                    ", Country: " + t.getCountry());
        }
    }

    public static void retrieveDataFromBothTables() {
    TeamsService ts = new TeamsService();

        // For JDBC CONNECTION TO GET DATA FROM DB from both the tables
        ts.getCricketerWithTeam();
    }

    // Rest of the methods for sorting and displaying data
}
