package com.muratk.insurancecampaignproject.business;


import com.muratk.insurancecampaignproject.entities.Campaign;

import java.util.List;

public interface CampaignService {

    List<Campaign> getAll();
    void addCampaign(Campaign campaign);
    Campaign makeActiveCampaign(int id);
    Campaign makeDeactivateCampaign(int id);



}
