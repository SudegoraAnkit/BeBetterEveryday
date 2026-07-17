package com.nexcommerce.user_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.nexcommerce.user_service.model.entity.User;

@Component
public interface UserService {

    /* Get All User details*/
    public List<User> getAllUsers();

    /* Get User details by ID */
    public User getUserById(UUID userId);

    /* Get User details by Email */
    public User getUserByEmail(String email);

    /* Create user */
    public void createUser(User user);

    /* Delete User by ID */
    public void deleteUserById(UUID userId);

    /* Delete user by email */
    public void deleteUserByEmail(String email);

    /* Update User details by ID */
    public void updateUserDetailById(User user);

    /* Update User details by email */
    public void updateUserDetailByEmail(User user);
}
