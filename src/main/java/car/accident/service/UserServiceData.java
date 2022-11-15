package car.accident.service;

import car.accident.model.User;
import car.accident.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceData {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
