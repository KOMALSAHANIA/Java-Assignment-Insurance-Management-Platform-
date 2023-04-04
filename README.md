# Java-Assignment-Insurance-Management-Platform-
Java Assignment contain all the files used in the development of Insurance Management Platform 

Project Title :
This is README file for a Spring Boot project using JPA and embedded H2 database named "Insurance Management Platform".

Description :
Insurance Management Platform  project contains all the  RestFul APIs for Clients ,Insurance Policies and Claims entities which allow users 
to call API of HttpRequest methods like GET,POST,PUT and DELETE.

Getting Started :
To run Project Title locally, follow these steps:
1. Clone the repository(Java-Assignment-Insurance-Management-Platform) to your local machine in any IDE (Netbeans ,Eclipse or IntelliJ). I have used Eclipse.
2. Run the main class named "InsuranceManagementPlatformApplication" in IDE.
3. To records in H2 DB type localhost:8080/h2-console in browser there are 3 tables named (TB_CLAIM,TB_CLIENT and TB_INSURANCE_POLICY) and to see records firstly 
   you have to call POST type API because its in memory database and in this data is stored as long as application is running otherwise data is erased.
5. To call any API of any of the model (Client,Claim or InsurancePolicy) for this open postman

Project Structure :
Here's a brief overview of the project's file structure ,please refer the same:

![Screenshot 2023-04-04 155143](https://user-images.githubusercontent.com/100118439/229771896-ac93802e-9d99-4a8f-88a3-01988997ceb8.png)

There are multiple packages.
"com.springboot.rest.api.InsuranceManagementPlatform" : Contains the main class of the application.
"com.springboot.rest.api.InsuranceManagementPlatform.Controller" : Contains controller class for handling frontend requests.
"com.springboot.rest.api.InsuranceManagementPlatform.Entity" : Contains entities like Claim,Client and InsurancePolicy to create table in H2 db.
"com.springboot.rest.api.InsuranceManagementPlatform.Repository" : It contains interface to use db DML queries.
"com.springboot.rest.api.InsuranceManagementPlatform.Service" : there are multiple services and their implementation classes in which business logic is defined and are used by controller class.
"src/main/resources" : Contains application.properties for database setting up H2 database configuration,JPA configurations.

Features :

For all RESTFUL apis.I have done exception handling and proper validation.

Please find some attachments of Postman for calling APIs. I have shared only Client APIs you can refer the same for Claims and Insurance policy.
![Screenshot 2023-04-03 143835](https://user-images.githubusercontent.com/100118439/229776337-34c64986-a9fd-42f2-9a89-5571f5837de6.png)
![Screenshot 2023-04-03 143901](https://user-images.githubusercontent.com/100118439/229776377-0a8e9070-2572-476d-8100-87dd5d85f2b2.png)
![Screenshot 2023-04-04 181235](https://user-images.githubusercontent.com/100118439/229795839-f8f4762e-f622-4ea4-b57d-a204e38d8521.png)
![Screenshot 2023-04-03 144221](https://user-images.githubusercontent.com/100118439/229776421-4c2cd559-ff59-447a-b385-dc46928d1359.png)
![Screenshot 2023-04-03 144428](https://user-images.githubusercontent.com/100118439/229776460-e4984079-6bfc-46e0-b4ae-ecefaef23c94.png)
![Screenshot 2023-04-03 144505](https://user-images.githubusercontent.com/100118439/229776487-0f85c047-98a3-444e-a81b-19dd1f964b40.png)
![Screenshot 2023-04-03 144645](https://user-images.githubusercontent.com/100118439/229776506-c4979525-f81e-4eb2-ab25-6f54e9759969.png)
![Screenshot 2023-04-03 144908](https://user-images.githubusercontent.com/100118439/229776066-24fd288a-9981-4bb1-8e08-e46be88bf13c.png)
