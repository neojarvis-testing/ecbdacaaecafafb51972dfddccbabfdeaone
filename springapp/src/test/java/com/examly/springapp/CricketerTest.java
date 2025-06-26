package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class CricketerTest {
	
	 private void checkClassExists(String className) {
	        try {
	            Class.forName(className);
	        } catch (ClassNotFoundException e) {
	            fail("Class " + className + " does not exist.");
	        }
	    }
	 
	 private void checkFieldExists(String className, String fieldName) {
	        try {
	            Class<?> clazz = Class.forName(className);
	            clazz.getDeclaredField(fieldName);
	        } catch (ClassNotFoundException | NoSuchFieldException e) {
	            fail("Field " + fieldName + " in class " + className + " does not exist.");
	        }
	    }
	 

	@Test
	public void Week1_Day1_testFieldExistence() {
		
		checkClassExists("com.examly.springapp.Cricketer");
	}

	@Test
	void Week1_Day1_testCricketerName() {
		checkFieldExists("com.examly.springapp.Cricketer", "name");

	}

	@Test
	void Week1_Day1_testCricketerAge() {

		checkFieldExists("com.examly.springapp.Cricketer", "age");
	}

	@Test
	void Week1_Day1_testCricketerCountry() {

		checkFieldExists("com.examly.springapp.Cricketer", "country");
	}

	@Test
	public void Week1_Day2_Clientinterface() {

		String directoryPath = "src/main/java/com/examly/springapp/client"; // Replace with the path to your
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Test

	public void Week1_Day2_serviceinterface() {

		String directoryPath = "src/main/java/com/examly/springapp/service"; // Replace with the path to your
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());

	}

	
	@Test
	public void Week1_Day3_testAddCricketersFunctionality() {
		try {
			Class<?> springAppClass = Class.forName("com.examly.springapp.SpringappApplication");
			Method[] methods = springAppClass.getDeclaredMethods();
	
			boolean methodExists = false;
	
			for (Method method : methods) {
				if (method.getName().equals("addCricketers")) {
					methodExists = true;
					break;
				}
			}
	
			assertTrue(methodExists, "Method 'addCricketers' should exist in SpringappApplication class");
		} catch (ClassNotFoundException e) {
			fail("Class 'SpringappApplication' not found: " + e.getMessage());
		}
	}


	//day 4
	@Test
	public void Week1_Day4_testSortCricketersFunctionality() {
		try {
			Class<?> springAppClass = Class.forName("com.examly.springapp.SpringappApplication");
			Method[] methods = springAppClass.getDeclaredMethods();
	
			boolean methodExists = false;
	
			for (Method method : methods) {
				if (method.getName().equals("sortCricketers")) {
					methodExists = true;
					break;
				}
			}
	
			assertTrue(methodExists, "Method 'sortCricketers' should exist in SpringappApplication class");
		} catch (ClassNotFoundException e) {
			fail("Class 'SpringappApplication' not found: " + e.getMessage());
		}
	}



	@Test
	public void Week1_Day5_JDBCUtils() {

		checkClassExists("com.examly.springapp.DAO.JDBCUtils");
	}


	@Test
	public void Week1_Day5_displayCricketersFromDB() {
		try {
			Class<?> springAppClass = Class.forName("com.examly.springapp.SpringappApplication");
			Method[] methods = springAppClass.getDeclaredMethods();
	
			boolean methodExists = false;
	
			for (Method method : methods) {
				if (method.getName().equals("displayCricketersFromDB")) {
					methodExists = true;
					break;
				}
			}
	
			assertTrue(methodExists, "Method 'displayCricketersFromDB' should exist in SpringappApplication class");
		} catch (ClassNotFoundException e) {
			fail("Class 'SpringappApplication' not found: " + e.getMessage());
		}
	}


	
	@Test
	public void Week1_Day6_CricketerDAO() {

		checkClassExists("com.examly.springapp.DAO.CricketDAO");
	}

	
@Test
	public void Week2_Day1_testRetrievedataFromBothTables() {
		try {
			Class<?> springAppClass = Class.forName("com.examly.springapp.SpringappApplication");
			Method[] methods = springAppClass.getDeclaredMethods();
	
			boolean methodExists = false;
	
			for (Method method : methods) {
				if (method.getName().equals("retrieveDataFromBothTables")) {
					methodExists = true;
					break;
				}
			}
	
			assertTrue(methodExists, "Method 'retrieveDataFromBothTables' should exist in SpringappApplication class");
		} catch (ClassNotFoundException e) {
			fail("Class 'SpringappApplication' not found: " + e.getMessage());
		}
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void Week2_Day2_testWelcome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/Welcome"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Welcome to SpringProject"));
	}

	@Test
	public void Week2_Day3_entitiesfolder() {

		String directoryPath = "src/main/java/com/examly/springapp/entities"; // Replace with the path to your
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}
	
	@Test
	public void Week2_Day3_repositoriesfolder() {

		String directoryPath = "src/main/java/com/examly/springapp/repositories"; // Replace with the path to your
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}
	
	@Test
	public void Week2_Day3_servicesfolder() {

		String directoryPath = "src/main/java/com/examly/springapp/services"; // Replace with the path to your
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}
	
	@Test
	public void Week2_Day3_controllersfolder() {

		String directoryPath = "src/main/java/com/examly/springapp/controllers"; // Replace with the path to your
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}
	@Test
	void Week2_Day3_getAllTeamsList() throws Exception {
		mockMvc.perform(get("/team/getAllList").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andReturn();
	}
	
	
	@Test
	public void Week2_Day4_TeamClass() {

		checkClassExists("com.examly.springapp.entities.Team");
		checkFieldExists("com.examly.springapp.entities.Team", "id");
		checkFieldExists("com.examly.springapp.entities.Team", "name");
		checkFieldExists("com.examly.springapp.entities.Team", "maximumBudget");
	}
	
	@Test
	public void Week3_Day3_testPlayerExistence() {
		checkClassExists("com.examly.springapp.entities.Player");
		checkFieldExists("com.examly.springapp.entities.Player", "name");
		checkFieldExists("com.examly.springapp.entities.Player", "age");
		checkFieldExists("com.examly.springapp.entities.Player", "category");


	}
	
	@Test
	public void Week2_Day4_ClassRepo() {

		checkClassExists("com.examly.springapp.repositories.TeamRepository");
		checkClassExists("com.examly.springapp.repositories.PlayerRepository");

	}
	
	
	@Test
	void Week2_Day5_Teamadd() throws Exception {
		String st = "{\"id\": 1000,\"name\": \"Demo\",\"maximumBudget\":15000}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/teams").contentType(MediaType.APPLICATION_JSON).content(st)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				// .andExpect(MockMvcResultMatchers.content().string("true")) // Correct way to
				// validate boolean response
				.andReturn();
	}

	@Test
	void Week2_Day6_getallTeam() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/teams").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andReturn();
	}
	

	@Test
	void Week3_Day2_playeradd() throws Exception {
		String st = "{\"id\": 1000,\"name\": \"Demo\", \"age\": 24,\"category\": \"Seniorteam\",\"biddingPrice\":15000,\"sold\":false,\"email\": \"Viratdemo@gmail.com\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/players").contentType(MediaType.APPLICATION_JSON).content(st)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				// .andExpect(MockMvcResultMatchers.content().string("true")) // Correct way to
				// validate boolean response
				.andReturn();
	}

	
	@Test
	void Week3_Day2_getallPlayerWithTeam() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/players").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andReturn();
	}

	@Test
	public void Week3_Day3_testFieldExistence() {
		checkFieldExists("com.examly.springapp.entities.Player", "team");


	}
	
	@Test
	void Week3_Day3_getallPlayerList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/organizer/player-list").param("teamId", "1000").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andReturn();
	}

	
	@Test
	void Week3_Day4_getallUnsoldPlayer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/organizer/unsold-players").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andReturn();
	}
	
	@Test
	void Week3_Day4_getallSoldPlayer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/organizer/sold-players").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andReturn();
	}
	
	
	@Test
	public void Week3_Day5_configfolder() {

		String directoryPath = "src/main/java/com/examly/springapp/configurations"; // Replace with the path to your
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void Week3_Day5_SpringSecurity() {
		checkClassExists("com.examly.springapp.configurations.ApplSecurityConfig");
		checkClassExists("com.examly.springapp.configurations.UserPrinciple");
	}

	@Test
	void Week3_Day6_Springsecurity() throws Exception {
		String st = "{\"username\": \"admin\",\"password\": \"admin123\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login").contentType(MediaType.APPLICATION_JSON)
				.content(st).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				// .andExpect(MockMvcResultMatchers.content().string("true")) // Correct way to
				// validate boolean response
				.andReturn();
	}

	@Test
	void Week3_Day6_SpringRegisterUser() throws Exception {
		String st = "{\"id\": 1000,\"username\": \"admin\",\"password\": \"admin123\",\"role\": \"ADMIN\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/register").contentType(MediaType.APPLICATION_JSON).content(st)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated())
				// .andExpect(MockMvcResultMatchers.content().string("true")) // Correct way to
				// validate boolean response
				.andReturn();
	}

	// @Test
	// public void testHelloSpring() throws Exception {
	// mockMvc.perform(MockMvcRequestBuilders.get("myapp/Welcome"))
	// .andExpect(MockMvcResultMatchers.status().isOk())
	// .andExpect(MockMvcResultMatchers.content().string("Welcome to Spring"));
	//  }

}
