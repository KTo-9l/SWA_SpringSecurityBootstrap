package org.sillysociety.repository.swa;

import org.sillysociety.models.swa.MyUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<MyUser, Integer> {
    MyUser findByEmail(String email);
    Boolean existsByLogin(String login);
    Optional<MyUser> findByLogin(String login);
}
