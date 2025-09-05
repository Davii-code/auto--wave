package com.autowave.repository;

import com.autowave.entities.Subscription;
import com.autowave.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    boolean existsByPlanIdAndStatus(Long planId, SubscriptionStatus status);
}
