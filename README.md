# LibraryClient

Client Library is a part of the project Library Micro Services. This module is a client java console app to request information from a web services in microservices environment

## Installation

Project created in Maven, all the dependencies are in a .pom document.

Compile the code but first cheque the Server Url in the following class:

```
public class Request {


    Client client = Client.create();
    String urlClient = "http://localhost:8080/library/search/search";
    
    AND
    
        public void validationRequest() {
            credentialsInput();
            Client client = Client.create();
            String urlClient = "http://localhost:8080/library/search/auth";



```
Update URL depending on server configuration



## Contributing
Academic Project for McGill University. No contributing is requested. 

## License
[MIT](https://choosealicense.com/licenses/mit/)