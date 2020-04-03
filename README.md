# Spring Cloud Configuration
https://dzone.com/articles/creating-a-springboot-configuration-server-using-d

# Example Spring Cloud Configuration Server & Client
This repo is based on the following example:
https://dzone.com/articles/spring-cloud-config-server-for-the-impatient

# Quick Start
- Crete the following table:
```
CREATE TABLE [dbo].[properties](  
	[application] [nvarchar](200) NULL DEFAULT (NULL),  
	[setting] [nvarchar](200) NULL DEFAULT (NULL),  
	[value] [nvarchar](200) NULL DEFAULT (NULL),  
	[profile] [nvarchar](200) NULL DEFAULT (NULL),  
	[label] [nvarchar](200) NULL DEFAULT (NULL)  
) ON [PRIMARY]
```

- In configServer, update the JDBC URL in DatabaseConfiguration.

- Run the config server use the following command inside configServer directory.
    ```
    > ./gradlew bootRun -Dspring-boot.run.profiles=pg-dev,jdbc
    ```

- Next create a sample configuration record using following `POST` request.
    ```
    > curl -H "Content-Type: application/json" -d "{\"application\":\"sampleconfigclient\",\"profile\":\"default\",\"label\":\"master\",\"setting\":\"sampleconfigclient.test1\",\"value\":99}" -X POST http://localhost:8888/api/props
    ```

- Now you try to run the following command inside configClient directory.
    ```
    > ./gradlew bootRun
    ```
- And test the client using the following `GET` request.
    ```
    > curl -X GET http://localhost:8080/api
    ```
- Update the configuration record using following `PUT` request.
    ```
    > curl -H "Content-Type: application/json" -d "{\"application\":\"sampleconfigclient\",\"profile\":\"default\",\"label\":\"master\",\"setting\":\"sampleconfigclient.test1\",\"value\":100}" -X PUT http://localhost:8888/api/props
    ```
- Execute the following curl to refresh the setting:
    ```
    > curl -X POST http://localhost:8080/actuator/refresh
    ```
 - Test the client using the following `GET` request.
     ```
     > curl -X GET http://localhost:8080/api
     ```