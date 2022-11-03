# SpringReward
## Run Project
**In IDE (Intellij, Eclipse)**

The enter point of the project is ```RetailRewardsApplication.java```. Open the project in IDE and run the class's ```main()``` method.
  
**In Linux environment**

To run the app in server, the Spring Boot Maven Plugin should be included in ```pom.xml```


```
<project>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>getting-started</artifactId>
    <!-- ... -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

Navigate to the root of the project via command line and execute the command


```mvn spring-boot:run```

**Compile to JAR file**

Build the maven project using command ```mvn package``` or ```maven install```. It will create the .jar file inside target folder.

Then run with command ```java -jar <ProjectName>.jar```


## Introduction
The project was implemented based on following requirement:

```
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
dollar spent between $50 and $100 in each transaction.
(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).
```
In the project, an in-memory database H2 was included. Initial data was included in ```/resources/data.sql``` and ```/resources/schema.sql```.

Currently, 3 users were created and 3 transactions with ```user_id = 1``` were in the database.


To get the reward point of user 1, send GET request to ```localhost:8009/rewards/1```.

To add new transactions, send POST request to ```localhost:8009/transaction``` with JSON data. Detailed information please check API part.

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

The in-memory H2 database is also configured in ```application.properities```.


