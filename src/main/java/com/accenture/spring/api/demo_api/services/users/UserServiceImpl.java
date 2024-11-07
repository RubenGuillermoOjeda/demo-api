package com.accenture.spring.api.demo_api.services.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.accenture.spring.api.demo_api.models.User;

@Service
public class UserServiceImpl implements IUSerService {

    @Autowired
    private RestClient restClient;

    private final String USERS_URL = "http://demo1542617.mockable.io/users";

    @Override
    public List<User> getUsers() {
        ResponseEntity<List<User>> response = restClient.get()
                .uri(USERS_URL)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});

        return response.getBody();
    }

    @Override
    public List<User> getActiveUsers() {
       return this.getUsers().stream().filter(user -> user.isActive).collect(Collectors.toList());
    }

    
}
