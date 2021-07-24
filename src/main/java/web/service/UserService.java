package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser (User user);

    void updateUser (User user);

    User getUserById(int id);

    void removeUser (int id);

    List<User> getAllUsers();

}
