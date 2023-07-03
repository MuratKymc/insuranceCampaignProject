package com.muratk.insurancecampaignproject.dataAccess;

import com.muratk.insurancecampaignproject.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
}
