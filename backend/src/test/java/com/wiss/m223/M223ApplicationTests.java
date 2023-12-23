package com.wiss.m223;

import com.wiss.m223.controller.AuthController;
import com.wiss.m223.controller.LoginRequest;
import com.wiss.m223.helper.JwtResponse;
import com.wiss.m223.model.User;
import com.wiss.m223.repository.UserRepository;
import com.wiss.m223.security.JwtUtils;
import com.wiss.m223.security.UserDetailsImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class M223ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Nested
	@ExtendWith(MockitoExtension.class)
	public class AuthControllerTest {

		@InjectMocks
		private AuthController authController;

		@Mock
		private AuthenticationManager authenticationManager;

		@Mock
		private JwtUtils jwtUtils;

		@Test
		public void testAuthenticateUser_Success() {
			// Vorbereitung
			LoginRequest loginRequest = new LoginRequest("testUser", "testPass");
			UserDetailsImpl userDetailsMock = mock(UserDetailsImpl.class);
			Authentication authentication = mock(Authentication.class);

			when(authenticationManager.authenticate(any())).thenReturn(authentication);
			when(jwtUtils.generateJwtToken(authentication)).thenReturn("testToken");
			when(authentication.getPrincipal()).thenReturn(userDetailsMock);

			// Ausführung
			ResponseEntity<?> response = authController.authenticateUser(loginRequest);

			// Überprüfung
			assertNotNull(response);
			assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
			assertTrue(response.getBody() instanceof JwtResponse);
		}
	}
		@Nested
		@ExtendWith(MockitoExtension.class)
		class UserRepositoryTest {

			@Mock
			private UserRepository userRepository;

			@Test
			public void testFindByUsername_Found() {
				// Vorbereitung
				User mockUser = new User();
				mockUser.setUsername("testUser");
				when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(mockUser));

				// Ausführung
				Optional<User> found = userRepository.findByUsername("testUser");

				// Überprüfung
				assertTrue(found.isPresent());
				assertEquals("testUser", found.get().getUsername());
			}
		}
	}
