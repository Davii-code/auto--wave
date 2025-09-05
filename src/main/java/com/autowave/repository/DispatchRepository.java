package com.autowave.repository;

import com.autowave.dto.report.CampaignStatsDTO;
import com.autowave.entities.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
    Optional<Dispatch> findTopByClientTelephoneOrderBySentAtDesc(String clientTelephone);
    boolean existsByCampaignId(Long campaignId);
    boolean existsByClientId(Long clientId);

    @Query("""
        SELECT new com.autowave.dto.campaign.CampaignStatsDTO(
            c.id,
            c.name,
            COUNT(d.id),
            SUM(CASE WHEN d.sentAt IS NOT NULL THEN 1 ELSE 0 END),
            SUM(CASE WHEN d.delivered = true THEN 1 ELSE 0 END),
            SUM(CASE WHEN d.responded = true THEN 1 ELSE 0 END)
        )
        FROM Campaign c
        LEFT JOIN Dispatch d ON d.campaign.id = c.id
        WHERE c.id = :campaignId
        GROUP BY c.id, c.name
    """)
    CampaignStatsDTO getCampaignStats(@Param("campaignId") Long campaignId);

    // Estatísticas de TODAS campanhas de um usuário
    @Query("""
        SELECT new com.autowave.dto.campaign.CampaignStatsDTO(
            c.id,
            c.name,
            COUNT(d.id),
            SUM(CASE WHEN d.sentAt IS NOT NULL THEN 1 ELSE 0 END),
            SUM(CASE WHEN d.delivered = true THEN 1 ELSE 0 END),
            SUM(CASE WHEN d.responded = true THEN 1 ELSE 0 END)
        )
        FROM Campaign c
        LEFT JOIN Dispatch d ON d.campaign.id = c.id
        WHERE c.user.id = :userId
        GROUP BY c.id, c.name
        ORDER BY c.id DESC
    """)
    List<CampaignStatsDTO> getAllCampaignStats(@Param("userId") Long userId);

    List<Dispatch> findTop20ByPendingTrueOrderByIdAsc();

}
