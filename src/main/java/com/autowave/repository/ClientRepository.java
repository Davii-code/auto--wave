package com.autowave.repository;

import com.autowave.entities.Client;
import com.autowave.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByBirthday(LocalDate birthday);
    List<Client> findByLastpurchaseBefore(LocalDate lastpurchase);
    List<Client> findByLastPurchase(LocalDate lastpurchase);
}
