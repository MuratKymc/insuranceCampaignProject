package com.muratk.insurancecampaignproject.webApi.controllers;

import com.muratk.insurancecampaignproject.business.CampaignService;
import com.muratk.insurancecampaignproject.entities.Campaign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class CampaignsControllerTest {

    @Mock
    CampaignService campaignService;
    private MockMvc mockMvc;


    /*public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new CampaignsController(campaignService)).build();

    }*/

    @Test
    public void testGetAll()   {

    }

    @Test
    public void testAddCampaign() {

    }

    @Test
    void makeActiveCampaign() {
    }

    @Test
    void makeDeactivateCampaign() {
    }

    @Test
    void calculateCampaignCounts() {
    }
}