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
    public ResponseEntity<String> addCampaign(@RequestBody Campaign campaign){
        this.campaignService.addCampaign(campaign);

        return ResponseEntity.ok("Veri eklendi.");
    }

    @PutMapping("/makeActiveCampaign")
    public ResponseEntity<String> makeActiveCampaign(@RequestParam int id){
        campaignService.makeActiveCampaign(id);
        return ResponseEntity.ok("Veri güncellendi.");
    }


    @PutMapping("/makeDeactivateCampaign")
    public ResponseEntity<String> makeDeactivateCampaign(@RequestParam  int id){
        campaignService.makeDeactivateCampaign(id);
        return ResponseEntity.ok("Veri Güncellendi.");
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
