package com.accenture.spring.services.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.accenture.spring.api.demo_api.exceptions.NoServiceException;
import com.accenture.spring.api.demo_api.generated.model.User;
import com.accenture.spring.api.demo_api.services.users.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTests {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private RestClient restClientMock;

    @InjectMocks
    private UserServiceImpl userServiceMock;

    ResponseEntity<List<User>> responseEntity;
    List<User> users;

     @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

        User user = new User();
        users = new ArrayList<>();
        user.setUserId("1");
        user.setUserName("ruben");
        user.setIsActive(true);
        users.add(user);
        responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Test
    void testGetUsers() {
        when(restClientMock.get().uri(anyString()).retrieve().toEntity(new ParameterizedTypeReference<List<User>>(){}))
        .thenReturn(responseEntity);

        List<User> responseUsers = userServiceMock.getUsers();

        assertEquals(users, responseUsers);
    }

    @Test
    void testGetUsersException() {
        when(restClientMock.get().uri(anyString()).retrieve().toEntity(new ParameterizedTypeReference<List<User>>(){}))
        .thenThrow(new HttpClientErrorException(HttpStatus.SERVICE_UNAVAILABLE));

        assertThrows(NoServiceException.class, () -> userServiceMock.getUsers());
    }

    @Test
    void testGetActiveUsers() {
        when(restClientMock.get().uri(anyString()).retrieve().toEntity(new ParameterizedTypeReference<List<User>>(){}))
        .thenReturn(responseEntity);

        List<User> responseUsers = userServiceMock.getUsers();

        assertEquals(users, responseUsers);
    }

}
