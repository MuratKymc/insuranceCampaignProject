package com.muratk.insurancecampaignproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "campaigns")
@Data
@AllArgsConstructor()
@NoArgsConstructor
@Entity
@Builder
public class Campaign {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Pattern(regexp = "^[a-z A-Z 0-9]+$", message = "Not Valid")
    @Size(min = 10, max = 50)
    @Column(name = "campaignsAdvertTitle")
    private String campaignsAdvertTitle;

    @Size(min = 20, max = 200)
    @Column(name = "campaignsDetails")
    private String campaignsDetails;

    //@Pattern(regexp = "^(?i)(Tamamlayıcı Sağlık Sigortası|Özel Sağlık Sigortası|Hayat Sigortası|Diğer)$", message = "not valid")
    @Column(name = "campaignCategory")
    private String campaignCategory;

    @Column(name = "campaignsStatus")
    private String campaignsStatus;
}
