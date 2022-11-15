package car.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import car.accident.model.Authority;
import car.accident.repository.AuthorityRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorityServiceData {

    private final AuthorityRepository authorityRepository;

    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }

    public Optional<Authority> findById(int id) {
        return authorityRepository.findById(id);
    }
}
