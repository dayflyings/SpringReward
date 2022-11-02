# SpringReward
## Run Project
```mvn spring-boot:run```

## API
**GET** **/rewards/{id}**
Calculate reward based on user_id


**GET** **/transaction/{id}**
Find all transactions based on user_id


**POST** **/transaction** 
Create a transaction based on request body


RequestBody example: ```{"id": 4, "value": 200, "userId": 1, "createdTime": "2022-01-02"}```

## Additional Information
Current project host on ```localhost:8009```. To change port, modify ```application.properities```.

A in-memory H2 database is also configured in ```application.properities```.


