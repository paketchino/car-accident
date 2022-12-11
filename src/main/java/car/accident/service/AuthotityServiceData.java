package car.accident.service;

import org.springframework.stereotype.Service;
import car.accident.model.Authority;
import car.accident.repository.AuthorityRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class AuthotityServiceData {

    private final AuthorityRepository authorityRepository;

    public AuthotityServiceData(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Transactional
    public void create(Authority authority) {
        authorityRepository.save(authority);
    }

    public Optional<Authority> findById(int id) {
        return authorityRepository.findById(id);
    }

}
