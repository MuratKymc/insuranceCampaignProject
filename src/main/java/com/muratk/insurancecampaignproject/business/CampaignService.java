package com.muratk.insurancecampaignproject.business;


import com.muratk.insurancecampaignproject.entities.Campaign;

public interface CampaignService {

    void addCampaign(Campaign campaign);

    void makeActiveCampaign(int id);


}
