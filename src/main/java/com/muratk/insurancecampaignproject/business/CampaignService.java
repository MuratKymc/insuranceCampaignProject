package com.muratk.insurancecampaignproject.business;


import com.muratk.insurancecampaignproject.entities.Campaign;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CampaignService {

    List<Campaign> getAll();

    Optional<Campaign> getCampaignById(Long id);

    ResponseEntity<String> addCampaign(Campaign campaign);
    Campaign makeActiveCampaign(Long id);
    Campaign makeDeactivateCampaign(Long id);
    int countCampaignStatus(String campaignsStatus);

    ResponseEntity<Map<String, Boolean>> deleteCampaign(Long id);



}
