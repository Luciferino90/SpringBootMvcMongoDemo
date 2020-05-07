package it.usuratonkachi.mongomvc.domain.repository;

import it.usuratonkachi.mongomvc.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUserid(String userid);

}
