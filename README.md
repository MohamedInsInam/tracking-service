**Parcel Tracking Number Generator API**
A Spring Boot API that generates unique tracking numbers for parcel shipments. It ensures thread safety, efficient processing, and valid request handling with built-in validation.

**Features**
Generates unique tracking numbers based on origin, destination, customer ID, and weight.
Strict validation rules on request parameters using Jakarta Validation.
Global Exception Handling for request errors.

**API Endpoints**
**Generate a New Tracking Number**

URL: /next-tracking-number
Method: POST
Content-Type: application/json
**Request Body** 
{
"origin_country_id": "US",
"destination_country_id": "CA",
"weight": 10.21,
"customer_id": "1021",
"customer_name": "John Doe",
"created_at": "2025-03-12T03:04:13.439765Z",
"customer_slug": "john-doe"
}

**Response**
{
"tracking_number": "SVUS10211",
"created_at": "2025-03-12T03:04:13.439765Z"
}

**Technology Stack**

Java 17
Spring Boot 3.x
Jakarta Validation API
ConcurrentHashMap & AtomicLong for unique tracking number generation


**Installation & Running Locally.**
**Prerequisites**

Ensure you have:
Java 17+ installed
Maven installed

Clone the Repository
git clone https://github.com/MohamedInsInam/tracking-service.git

Build & Run the Project
mvn clean install
mvn spring-boot:run

Test the API
http://localhost:8080/next-tracking-number

**This tracking application is deployed on "Railway.app"**
**To test the api using postman please find below details.**

**URL**
https://tracking-service-production-05c2.up.railway.app/next-tracking-number

**Method**
GET

**Request Body**
{
"origin_country_id": "US",
"destination_country_id": "CA",
"weight": 10.21,
"customer_id": "1021",
"customer_name": "John Doe",
"created_at": "2025-03-12T03:04:13.439765Z",
"customer_slug": "john-doe"
}

**Also deployed tracking api service can be tested using below postman curl.**

curl --location --request GET 'https://tracking-service-production-05c2.up.railway.app/next-tracking-number' \
--header 'Content-Type: application/json' \
--data '{
"origin_country_id": "SV",
"destination_country_id": "US",
"weight": 10,
"customer_id": ",dfjnbgf.ljfghljr.oirjgo",
"customer_name": "John Doe",
"created_at": "2018-11-20T19:29:32Z",
"customer_slug": "invalid-slug"
}'