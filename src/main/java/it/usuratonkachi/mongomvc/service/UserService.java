package it.usuratonkachi.mongomvc.service;

import it.usuratonkachi.mongomvc.domain.entity.User;
import it.usuratonkachi.mongomvc.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserService {

    @Autowired private UserRepository userRepository;

    public User findByUserId(String userid) {
        return userRepository.findByUserid(userid)
                .orElseThrow(() -> new RuntimeException("user not found for id " + userid));
    }

    public User create(User user) {
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
