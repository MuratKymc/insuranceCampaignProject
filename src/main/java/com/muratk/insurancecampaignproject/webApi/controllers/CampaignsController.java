package com.muratk.insurancecampaignproject.webApi.controllers;

import com.muratk.insurancecampaignproject.business.CampaignService;
import com.muratk.insurancecampaignproject.entities.Campaign;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@AllArgsConstructor
public class CampaignsController {

    private CampaignService campaignService;

    @GetMapping("/getAllCampaigns")
    public List<Campaign> getAll(){
        return campaignService.getAll();
    }

    @PostMapping("/addCampaign")
    public void addCampaign(Campaign campaign){
        this.campaignService.addCampaign(campaign);
    }

    @PutMapping("/makeActiveCampaign")
    public void makeActiveCampaign(int id){
        this.campaignService.makeActiveCampaign(id);
    }

    @PutMapping("/makeDeactivateCampaign")
    public void makeDeactivateCampaign(int id){
        this.campaignService.makeDeactivateCampaign(id);
    }

}
