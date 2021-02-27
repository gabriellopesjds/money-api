package com.gabriellopesjds.moneyapi.user.persistence;

import com.gabriellopesjds.moneyapi.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

}
