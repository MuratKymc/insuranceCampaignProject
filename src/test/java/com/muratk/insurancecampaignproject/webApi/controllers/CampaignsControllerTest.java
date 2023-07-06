package com.muratk.insurancecampaignproject.webApi.controllers;

import com.muratk.insurancecampaignproject.business.CampaignService;
import com.muratk.insurancecampaignproject.entities.Campaign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@WebMvcTest(controllers = CampaignsController.class)
@ActiveProfiles("test")
class CampaignsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CampaignService campaignService;

    @InjectMocks
    CampaignsController campaignsController;

    private List<Campaign> campaignList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        campaignsController = new CampaignsController(campaignService);
    }


    @Test
    void testGetAll() {
        Campaign campaign1 = new Campaign();
        Campaign campaign2 = new Campaign();
        List<Campaign> expectedCampaigns = Arrays.asList(campaign1, campaign2);

        when(campaignService.getAll()).thenReturn(expectedCampaigns);

        List<Campaign> actualCampaigns = campaignsController.getAll();

        assertEquals(expectedCampaigns, actualCampaigns);
    }

    @Test
    void testAddCampaign() {
        Campaign campaign = new Campaign();

        ResponseEntity<String> response = campaignsController.addCampaign(campaign);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Veri eklendi.", response.getBody());
    }

    @Test
    void TestMakeActiveCampaign() {
        int campaignId = 1;

        // Act
        ResponseEntity<String> response = campaignsController.makeActiveCampaign(campaignId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Veri güncellendi.", response.getBody());
    }


    @Test
    void TestMakeDeactivateCampaign() {
        int campaignId = 1;

        ResponseEntity<String> response = campaignsController.makeDeactivateCampaign(campaignId);


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Veri Güncellendi.", response.getBody());
    }


    @Test
    void calculateCampaignCounts_ReturnsCountMap() {
        int activeCount = 2;
        int inactiveCount = 3;
        int duplicateCount = 1;

        when(campaignService.countCampaignStatus("Aktif")).thenReturn(activeCount);
        when(campaignService.countCampaignStatus("Deaktif")).thenReturn(inactiveCount);
        when(campaignService.countCampaignStatus("Mükerrer")).thenReturn(duplicateCount);

        Map<String, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put("Aktif", activeCount);
        expectedCounts.put("Deaktif", inactiveCount);
        expectedCounts.put("Mükerrer", duplicateCount);

        ResponseEntity<Map<String, Integer>> response = campaignsController.calculateCampaignCounts();
        Map<String, Integer> actualCounts = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCounts, actualCounts);
    }


}