# Sample Spring Boot Configuration Server & Client
https://dzone.com/articles/spring-cloud-config-server-for-the-impatient

## Sample Springboot Configuration Server
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
    > curl -H "Content-Type: application/json" -d "{\"application\":\"sampleconfigclient\",\"profile\":\"default\",\"label\":\"master\",\"setting\":\"sampleconfigclient.test1\",\"value\":99}" -X POST http://localhost:8082/api/props
    ```

- Now you try to run the following command inside configClient directory.
    ```
    > ./gradlew bootRun
    ```
- And test the client using the following `GET` request.
    ```
    > curl -X GET http://localhost:8080/api
    ```
- Update the setting in the database:
    ```
    UPDATE [dbo].[properties]
     SET [value] = '500'
     WHERE [setting] = 'sampleconfigclient.test1'
    ```
- Execute the following curl to refresh the setting:
    ```
    > curl -X POST http://localhost:8080/actuator/refresh
    ```
 - Test the client using the following `GET` request.
     ```
     > curl -X GET http://localhost:8080/api
     ```