package com.muratk.insurancecampaignproject.business;

import com.muratk.insurancecampaignproject.dataAccess.CampaignRepository;
import com.muratk.insurancecampaignproject.entities.Campaign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.*;



@SpringBootTest
@RunWith(SpringRunner.class)
class CampaignManagerTest {

    @Mock
    private CampaignRepository campaignRepository;

    private MockMvc mockMvc;

    @Autowired
    private CampaignManager campaignManager;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void testGetAll() throws Exception {

        List<Campaign> listCampaign = new ArrayList<>();
        listCampaign.add(new Campaign(3,"testAdvertTitle","TestCampaignDetails","TestCampaignCategory","TestCampaignStatus"));

        String url = "/api/campaigns/getAllCampaigns";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }


    @Test
    void testAddCampaign() throws Exception{
        String url = "/api/campaigns/addCampaign";

        MvcResult mvcResult = mockMvc.perform(get(url)).andReturn();

    }


    @Test
    void testMakeActiveCampaign() throws Exception{

        Campaign campaign = new Campaign();
        Campaign updatedCampaign = new Campaign(5,"testAdvertTitle","TestCampaignDetails","TestCampaignCategory","TestCampaignStatus");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/campaigns/makeActiveCampaign",updatedCampaign.getCampaignsStatus()));
    }

    @Test
    void testMakeDeactiveCampaign() throws Exception{

        Campaign campaign = new Campaign();
        Campaign updatedDeactiveCampaign = new Campaign(45,"testAdvertTitle","TestCampaignDetails","TestCampaignCategory","TestCampaignStatus");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/campaigns/makeDeactiveCampaign",updatedDeactiveCampaign.getCampaignsStatus()));
    }


    @Test
    void testCountCampaignStatus() {
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(new Campaign());
        campaigns.add(new Campaign());

        when(campaignRepository.findByCampaignsStatus("Aktif")).thenReturn(campaigns);

        int result = campaignManager.countCampaignStatus("Aktif");

        assertEquals(11, result);

    }

}