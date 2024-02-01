package test.com.healthtracker.model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import main.com.healthtracker.model.domain.User;

public class UserTest {

	private User user;

	@BeforeEach
	public void setUp() {
		user = new User("John Doe", 30, 180, 80.0, "Male", 2000);
	}

	@Test
	public void testGetUserId() {
		assertNotNull(user.getUserId());
		assertEquals(UUID.class, user.getUserId().getClass());
	}

	@Test
	public void testGetName() {
		assertEquals("John Doe", user.getName());
	}

	@Test
	public void testGetAge() {
		assertEquals(30, user.getAge());
	}

	@Test
	public void testGetHeightInCm() {
		assertEquals(180, user.getHeightInCm());
	}

	@Test
	public void testGetWeightInKg() {
		assertEquals(80.0, user.getWeightInKg(), 0.01);
	}

	@Test
	public void testGetGender() {
		assertEquals("Male", user.getGender());
	}

	@Test
	public void testGetDailyCalorieGoal() {
		assertEquals(2000, user.getDailyCalorieGoal());
	}

	@Test
	public void testSetName() {
		user.setName("Jane Doe");
		assertEquals("Jane Doe", user.getName());
	}

	@Test
	public void testSetAge() {
		user.setAge(35);
		assertEquals(35, user.getAge());
	}

	@Test
	public void testSetHeightInCm() {
		user.setHeightInCm(185);
		assertEquals(185, user.getHeightInCm());
	}

	@Test
	public void testSetWeightInKg() {
		user.setWeightInKg(85.0);
		assertEquals(85.0, user.getWeightInKg(), 0.01);
	}
}
