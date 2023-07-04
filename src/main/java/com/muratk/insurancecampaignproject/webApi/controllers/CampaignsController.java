package com.muratk.insurancecampaignproject.webApi.controllers;

import com.muratk.insurancecampaignproject.business.CampaignService;
import com.muratk.insurancecampaignproject.entities.Campaign;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/get/dashboard/classifieds/statistics")
    public ResponseEntity<Map<String, Integer>> calculateCampaignCounts(){
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Aktif", campaignService.countCampaignStatus("Aktif"));
        counts.put("Deaktif", campaignService.countCampaignStatus("Deaktif"));
        counts.put("Mükerrer", campaignService.countCampaignStatus("Mükerrer"));

        return ResponseEntity.ok(counts);
    }

}
