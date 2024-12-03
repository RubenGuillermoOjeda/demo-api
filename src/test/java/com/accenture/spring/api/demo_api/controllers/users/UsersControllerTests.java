package com.accenture.spring.api.demo_api.controllers.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accenture.spring.api.demo_api.generated.model.User;
import com.accenture.spring.api.demo_api.services.users.IUSerService;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTests {

    @Mock
    private IUSerService userServiceMock;

    @InjectMocks
    private UsersController userController;

    private List<User> users = new ArrayList<>();


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

        User user = new User();
        user.setUserId("1");
        user.setUserName("ruben");
        user.setIsActive(true);
        users.add(user);
    }

    @Test
    public void testGetUsersAll() {
        when(this.userServiceMock.getUsers()).thenReturn(users);

        ResponseEntity<List<User>> response =  userController.getUsers(false);

        assertEquals(users, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetUsersActive() {
        when(this.userServiceMock.getActiveUsers()).thenReturn(users);

        ResponseEntity<List<User>> response =  userController.getUsers(true);

        assertEquals(users, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
}
