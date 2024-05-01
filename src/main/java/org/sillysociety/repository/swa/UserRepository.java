package org.sillysociety.repository.swa;

import org.sillysociety.models.swa.MyUser;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends CrudRepository<MyUser, Integer> {
    MyUser findByEmail(String email);
    Boolean existsByLogin(String login);
    Optional<MyUser> findByLogin(String login);
    @Query("update MyUser e set e.deleted=true where e.id=?1")
    @Transactional
    @Modifying
    void softDelete(Integer id);
}
