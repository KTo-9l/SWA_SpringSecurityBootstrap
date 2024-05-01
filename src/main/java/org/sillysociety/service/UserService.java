package org.sillysociety.service;

import org.sillysociety.models.swa.MyUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    MyUser addUser(MyUser myUser);
    void delete(MyUser myUser);
    MyUser getById(Integer id);
    List<MyUser> getAllUsers();
    MyUser updateUser(MyUser myUser);
    MyUser getByEmail(String email);
    Boolean existsByLogin(String login);
    void safeDelete(MyUser myUser);
}
