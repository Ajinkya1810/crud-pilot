
# CRUD Pilot 
* #### CRUD Pilot is a versatile Spring Boot application designed to serve as a generic platform for 
#### performing Create, Read, Update, and Delete (CRUD) operations on various elements.

* JPA - completed
* Deployment local - completed
* H2 In Memory Db - completed 
* Bulk upload - completed
* Gateway / Authentication
* Gateway / Routing
* Caching
* Async / rest-api's which will not wait for the response but makes entry in the Db with AckID and 
  will wait for the given SLA timeout to receive response from requested source 
* Hibernate - completed
* AOP - Implement Aspect 
* SMS service - completed
* Email service - completed
* Swagger API Specification - will be used as input
* Transaction logging - completed

## The following was discovered as part of building this project:

### Steps to deploy application locally [Windows] :
* Create an Executable JAR File 
  * Build an executable JAR file by running the following Maven command (if you are using Maven)
    * mvn clean install
    

* Run the JAR File
  * Open a terminal, navigate to the directory containing your JAR file, and run the following command
    * Start-Process "java" -ArgumentList "-jar", ".\crud-pilot-0.0.1-SNAPSHOT.jar" -NoNewWindow


* To stop a running Java process in PowerShell, you can use the Stop-Process cmdlet.
  * Identify the Process ID (PID):
    * Run the following command to list all processes with the name "java" and 
      find the Process ID (PID) of the Java process you want to stop.
      * Get-Process | Where-Object { $_.ProcessName -eq "java" }
      
  * Stop the Java Process:
    * Once you have identified the PID of the Java process you want to stop, use the following command to stop it.
      * Stop-Process -Id <PID>
  * For Force to Stop
    * Get-Process -Name "java" | Stop-Process -Force
