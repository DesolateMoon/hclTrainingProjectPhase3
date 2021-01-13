package com.junit;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junit.model.User;

public class AuthenticationTest {

		@BeforeEach
		public void setup() {
			Authentication.userList.add(User.builder().userName("Austin").password("pass").role("Admin").build());
			Authentication.userList.add(User.builder().userName("Julia").password("foo").role("User").build());
			Authentication.userList.add(User.builder().userName("Lan").password("bar").role("Developer").build());
			Authentication.userList.add(User.builder().userName("Chuong").password("jar").role("Tester").build());
		}
	
		@Test
		public void testLogin() {
			Authentication authentication = new Authentication();
			assertEquals(true, authentication.login("Austin", "pass"));
		}
		
		@Test
		public void testWrongUserLogin() {
			Authentication authentication = new Authentication();
			assertEquals(false, authentication.login("Krishna", "pass"));
		}
		
		@Test
		public void testRoleAssert() {
			Authentication authentication = new Authentication();
			assertEquals(true, authentication.login("Austin", "pass"));
			assertEquals("Admin", authentication.getRole());
		}
		
		@Test
		public void testUserAssert() {
			Authentication authentication = new Authentication();
			assertEquals(true, authentication.login("Austin", "pass"));
			assertEquals("Austin", authentication.getUserName());
		}
		
		@Test
		public void testLogout() {
			Authentication authentication = new Authentication();
			authentication.logout();
			assertEquals(null, authentication.getRole());
		}
}
