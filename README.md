# MultipleIBANVerificationService
<br/>
<br/>
Deployment instructions: <br/>
  prerequisites: <br/>
    - Java JDK 11.0.7 installed and JAVA_HOME environment variable set
    - Port localhost:8082 should not be blocked
    - Following REST API deployed and running: <br/>
      https://github.com/tautvydaskub/SingleIBANVerificationService (uses port localhost:8081)<br/>
  deployment steps:<br/>
    - Build the application. Command: %LocalRepositoryPath%/mvnw clean package<br/>
    - Run the application. Command: java -jar %LocalRepositoryPath%/target/multipleibanvalidation-1.0.0.jar<br/>
