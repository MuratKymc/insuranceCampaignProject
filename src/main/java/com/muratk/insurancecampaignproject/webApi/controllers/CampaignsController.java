package com.muratk.insurancecampaignproject.webApi.controllers;

import com.muratk.insurancecampaignproject.business.CampaignService;
import com.muratk.insurancecampaignproject.dataAccess.CampaignRepository;
import com.muratk.insurancecampaignproject.entities.Campaign;
import com.muratk.insurancecampaignproject.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/campaignsApp")
@AllArgsConstructor
@NoArgsConstructor
public class CampaignsController {

    @Autowired
    private CampaignService campaignService;
    private CampaignRepository campaignRepository;




    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/campaigns")
    public List<Campaign> getAll(){

        return campaignService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/campaigns/id/{id}")
    public Optional<Campaign> getCampaignById(@PathVariable Long id){

        return  campaignService.getCampaignById(id);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/campaigns")
    public ResponseEntity<String> addCampaign(@RequestBody Campaign campaign){
        this.campaignService.addCampaign(campaign);

        return ResponseEntity.ok("Veri eklendi.");
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/campaigns/activate/{id}")
    public ResponseEntity<String> makeActiveCampaign(@PathVariable Long id){
        campaignService.makeActiveCampaign(id);
        return ResponseEntity.ok("Veri güncellendi.");
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/campaigns/deactivate/{id}")
    public ResponseEntity<String> makeDeactivateCampaign(@PathVariable  Long id){
        campaignService.makeDeactivateCampaign(id);
        return ResponseEntity.ok("Veri Güncellendi.");
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/campaigns/statistics")
    public ResponseEntity<Map<String, Integer>> calculateCampaignCounts(){
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Aktif", campaignService.countCampaignStatus("Aktif"));
        counts.put("Deaktif", campaignService.countCampaignStatus("Deaktif"));
        counts.put("Mukerrer", campaignService.countCampaignStatus("Mukerrer"));
        counts.put("Onay Bekliyor", campaignService.countCampaignStatus("Onay Bekliyor"));

        return ResponseEntity.ok(counts);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/campaigns/{id}")
    public ResponseEntity<Map<String, Boolean>>  deleteEmployee(@PathVariable Long id){
        return campaignService.deleteCampaign(id);
    }

}
