package com.muratk.insurancecampaignproject.business;


import com.muratk.insurancecampaignproject.entities.Campaign;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CampaignService {

    List<Campaign> getAll();
    ResponseEntity<String> addCampaign(Campaign campaign);
    Campaign makeActiveCampaign(int id);
    Campaign makeDeactivateCampaign(int id);
    int countCampaignStatus(String campaignsStatus);



}
