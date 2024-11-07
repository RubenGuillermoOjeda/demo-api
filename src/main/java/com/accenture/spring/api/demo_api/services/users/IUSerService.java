package com.accenture.spring.api.demo_api.services.users;

import java.util.List;

import com.accenture.spring.api.demo_api.models.User;

public interface IUSerService {

    public List<User> getUsers();

    public List<User> getActiveUsers();

}
