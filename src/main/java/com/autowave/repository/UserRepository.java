package com.autowave.repository;

import com.autowave.entities.EvolutionInstance;
import com.autowave.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);
    User findByLogin(String login);
    User findByEmail(String email);
    @Query("select new com.autowave.entities.EvolutionInstance(u.instanceNameEvolution, u.apiKeyEvolution) from User u where u.id = :userId")
    EvolutionInstance getEvolutionInstanceByUserId(Long userId);
}
