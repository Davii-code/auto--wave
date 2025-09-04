package com.autowave.repository;

import com.autowave.entities.Client;
import com.autowave.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
