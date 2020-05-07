package it.usuratonkachi.mongomvc.service;

import it.usuratonkachi.mongomvc.domain.entity.User;
import it.usuratonkachi.mongomvc.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUserId(String userid) {
        return userRepository.findByUserid(userid)
                .orElseThrow(() -> new RuntimeException("user not found for id " + userid));
    }

    public User create(User user) {
        user.setUserid(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    public User update(User user) {
        User olduser = userRepository.findByUserid(user.getUserid())
                .orElseThrow(() -> new RuntimeException("user not found for id " + user.getUserid()));
        olduser
                .setUsername(user.getUsername())
                .setCompanyid(user.getCompanyid())
                .setFirstname(user.getFirstname())
                .setLastname(user.getLastname());
        return userRepository.save(olduser);
    }

}
