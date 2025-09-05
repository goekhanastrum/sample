# Demo sample project for iso

# Installation

Create mysql container with docker
docker run --name sample-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sampledb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -p 3306:3306 -d mysql:8.0

you can access the db with
docker exec -it sample-mysql mysql -uadmin -padmin sampledb

cd to root Directory:
mvnw spring-boot:run
or
mvnw clean package 
java -jar target/<name>.jar

links:
http://localhost:8080/api/samples
http://localhost:8080/swagger-ui/index.html
