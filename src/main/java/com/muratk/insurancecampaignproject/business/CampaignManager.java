package com.muratk.insurancecampaignproject.business;

import com.muratk.insurancecampaignproject.dataAccess.CampaignRepository;
import com.muratk.insurancecampaignproject.entities.Campaign;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CampaignManager implements CampaignService {

    private CampaignRepository campaignRepository;

    //Tüm kampanyaları getirme (read)
    @Override
    public List<Campaign> getAll() {

        List<Campaign> campaigns = campaignRepository.findAll();
        return campaigns;
    }

    //kampanya ekleme (create)
    @Override
    public void addCampaign(Campaign campaign) {

        //hayat sigortası haricindeki kampanyaların durumunun Onay bekliyor olarak belirlenmesi
        if (campaign.getCampaignCategory().equalsIgnoreCase("Hayat Sigortası")) {
            campaign.setCampaignsStatus("Aktif");
        } else {
            campaign.setCampaignsStatus("Onay Bekliyor");
        }


        //Tekrar eden kampanyaları tutmak için liste
        List<Campaign> existingCampaigns = campaignRepository.findByCampaignCategoryAndCampaignsAdvertTitleAndCampaignsDetails(
                campaign.getCampaignCategory(), campaign.getCampaignsAdvertTitle(), campaign.getCampaignsDetails());

        //aynı kategori,başlık ve açıklamaya sahip kampanyaların veri tabanına eklenmemesi için kontrol
        if (!existingCampaigns.isEmpty()) {
            campaign.setCampaignsStatus("Mükerrer");
            campaignRepository.save(campaign);
            throw new RuntimeException("Mükerrer veri!");
        }

        this.campaignRepository.save(campaign);

    }


    //kampanya aktive etme (update)
    @Override
    public Campaign makeActiveCampaign(int id) {

        Campaign campaign1 = campaignRepository.findById(id).get();

        campaign1.setCampaignsStatus("Aktif");

        return campaignRepository.save(campaign1);

    }

    //kampanya deaktive etme (update)
    @Override
    public Campaign makeDeactivateCampaign(int id) {

        Campaign campaign1 = campaignRepository.findById(id).get();

        campaign1.setCampaignsStatus("Deaktif");

        return campaignRepository.save(campaign1);

    }

}

