package org.sillysociety.service.impl;

import org.sillysociety.config.MyUserDetails;
import org.sillysociety.models.swa.MyUser;
import org.sillysociety.repository.swa.UserRepository;
import org.sillysociety.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUser addUser(MyUser myUser) {
        return userRepository.save(myUser);
    }

    @Override
    public void delete(MyUser myUser) {
        userRepository.delete(myUser);
    }

    @Override
    public MyUser getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<MyUser> getAllUsers() {
        return (List<MyUser>) userRepository.findAll();
    }

    @Override
    public MyUser updateUser(MyUser myUser) {
        return userRepository.save(myUser);
    }

    @Override
    public MyUser getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUser = userRepository.findByLogin(username);
        return myUser.map(MyUserDetails::new)
                .orElse(null);
    }

    @Override
    public Boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public void safeDelete(MyUser myUser) {
        userRepository.softDelete(myUser.getId());
        userRepository.save(myUser);
    }
}
