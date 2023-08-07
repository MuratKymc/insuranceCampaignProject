
# Spring Boot : insuranceCampaignProject

### Frontend:
You can see the frontend part of the project by following this link: https://github.com/MuratKymc/insuranceCampaignProject-frontend.git

## Introduction
A demo Spring Boot project where users can enter campaigns, publis and unpublish their campaigns whenever they want, and implement many functions of the campaign with crud operations.

## Technologies
- **Java**
- **Spring Boot**
- **MySQL**
- **JPA**
- **JUnit**
- **Maven**
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
  "/api/campaignsApp"
```

| Method | Url     | Decription                |
| :-------- | :------- | :------------------------- |
| `GET` | `"/campaigns"` | Get all campaigns. |
| `GET` | `"/campaigns/statistics"` | Lists the number of campaigns by campaign status. |
| `GET` | `"/campaigns/id/{id}"` | Get campaign by id. |
| `Post` | `"/campaigns"` | Add campaign. |
| `Put` | `"/campaigns/activate/{id}"` | Activates the campaign status. |
| `Put` | `"/campaigns/deactivate/{id}"` | Deactivates the campaign status. |
| `Delete` | `"/campaigns/{id}"` | Delete campaign by id. |


## Swagger

![image](https://github.com/MuratKymc/insuranceCampaignProject/assets/99142274/cab8e2c8-2b34-43e1-a56e-7659e2a0fc40)
