
# Spring Boot : insuranceCampaignProject

## Introduction
A demo Spring Boot project where users can enter campaigns, publis and unpublish their campaigns whenever they want, and implement many functions of the campaign with crud operations.

## Technologies
- **Java**

- **Spring Boot**

- **PostgreSQL**

- **JPA**

- **JUnit**

- **Swagger**

### Maven Dependencies

- Spring Boot DevTools
- Lombok
- Spring Web
- Spring Data Jpa
- PostgreSQL Driver
- Validation
- JUnit
- Mockito


## Explore APIs


```http
  "/api/campaigns"
```

| Method | Url     | Decription                |
| :-------- | :------- | :------------------------- |
| `GET` | `"/getAllCampaigns"` | Get all campaigns. |
| `GET` | `"/get/dashboard/classifieds/statistics"` | Lists the number of campaigns by campaign status |
| `Post` | `"/addCampaign"` | Add campaign |
| `Put` | `"/makeActiveCampaign"` | Activates the campaign status |
| `Put` | `"/makeDeactiveCampaign"` | Deactivates the campaign status |



## Swagger
![image](https://github.com/MuratKymc/insuranceCampaignProject/assets/99142274/cda0adeb-3d66-4a16-947a-446b04a9d8eb)
