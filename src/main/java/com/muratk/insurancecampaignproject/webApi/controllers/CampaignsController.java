package com.muratk.insurancecampaignproject.webApi.controllers;

import com.muratk.insurancecampaignproject.business.CampaignService;
import com.muratk.insurancecampaignproject.entities.Campaign;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/campaigns")
@AllArgsConstructor
public class CampaignsController {

    private CampaignService campaignService;

    @PostMapping()
    public void addCampaign(Campaign campaign){
        this.campaignService.addCampaign(campaign);
    }

    @PutMapping("/makeActiveCampaign")
    public void makeActiveCampaign(int id){
        this.campaignService.makeActiveCampaign(id);
    }

}
