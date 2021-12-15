# Spring Boot with Drools integration
Spring Boot app with drools rule engine integration

## Set up
- Download 'PreChecks.jar' from the repo droolspoc/src/main/resources folder to your local machine
- Update the systemPath tag with the download JAR location of the pom.xml file
- Update below 3 attributes in the application.properties with local file dir location with 3 folders (input, output, error)
    - app.directory.input= LOCAL_PATH_DIR/input 
    - app.directory.output=LOCAL_PATH_DIR/output
    - app.directory.error=LOCAL_PATH_DIR/error
- Build the app

## Run the application
- Start the spring boot application in your IDE

## Test the endpoints
- UseCase 2: Demonstrate the call to external system based on the results of rule execution
    - Use below end point in postman
    - ```http://localhost:8080/usecase2```
    - Request payload 1
    ```
      {
        "recordLocator": "RECORDLOCATOR-XXX",
        "pnrCreationDate": "2021-10-13T00:00:00.945Z",
        "numInParty": 1,
        "numOfSegments": 1,
        "ticketTypeIndicator": "TICKET_IND",
        "ticketText": "TICKET_TEXT",
        "fareLockType": "AUTO",
        "eventType": null,
        "passenger": {
            "firstName":"Mallikarjun",
            "lastName":"Mallikarjun",
            "eliteStatusCode":1,
            "lastNamePos":2,
            "firstNamePos":3,
            "segment":{
                "origin" : "Hyderabad",
                "destination" : "London",
                "carrierCode" : "AIR-HYD-LON"
            }
        },
        "pnrContactData": {
            "email" : "mallik@xyz.com",
            "homePhone" : "987654321"
        }
    }
      ```
  - Request payload 2
```
    {
        "recordLocator": "RECORDLOCATOR-XXX",
        "pnrCreationDate": "2021-10-13T00:00:00.945Z",
        "numInParty": 1,
        "numOfSegments": 1,
        "ticketTypeIndicator": "TICKET_IND",
        "ticketText": "TICKET_TEXT",
        "fareLockType": "NON_AUTO",
        "eventType": null,
        "passenger": {
        "firstName":"Mallikarjun",
        "lastName":"Mallikarjun",
        "eliteStatusCode":1,
        "lastNamePos":2,
        "firstNamePos":3,
        "segment":{
            "origin" : "Hyderabad",
            "destination" : "London",
            "carrierCode" : "AIR-HYD-LON"
        }
        },
        "pnrContactData": {
        "email" : "mallik@xyz.com",
        "homePhone" : "987654321"
        }
    }
```

- UseCase 3: Demonstrate the processing of message events from message broker
    - Place the same payload of use case 2 in the input directory of location mentioned in app.directory.input above
    - Check the output in the output directory of the location mentioned in app.directory.output above
    
- UseCase 4: Demonstrate of calling method of external JAR library
    - Use below end point in postman
    - ```localhost:8080/getCustomerCategory```
    - Sample request payload: 
      ```
      {
      "age": 25,
      "name": "Mallikarjun",
      "category": null
      }
      ```


