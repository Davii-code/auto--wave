package com.autowave.repository;

import com.autowave.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    boolean existsByUserId(Long userId);

}
