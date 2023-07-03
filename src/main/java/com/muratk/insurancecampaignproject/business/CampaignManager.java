package com.muratk.insurancecampaignproject.business;

import com.muratk.insurancecampaignproject.dataAccess.CampaignRepository;
import com.muratk.insurancecampaignproject.entities.Campaign;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CampaignManager implements CampaignService {

    private CampaignRepository campaignRepository;

    @Override
    public void addCampaign(Campaign campaign) {

        if (campaign.getCampaignCategory().equalsIgnoreCase("Hayat Sigortası")){
            campaign.setCampaignsStatus("Aktif");
        }else {
            campaign.setCampaignsStatus("Onay Bekliyor");
        }

        this.campaignRepository.save(campaign);
    }

    @Override
    public void makeActiveCampaign(int id) {
        campaignRepository.findById(id).get().setCampaignsStatus("Aktif");
    }

}

