# Demo sample project for ISO - ITZBund ZER - RV SDM

## Create MySQL container with docker
```bash
docker run --name sample-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sampledb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -p 3306:3306 -d mysql:8.0
```
## DB Access
```bash
docker exec -it sample-mysql mysql -uadmin -padmin sampledb
```
## Navigate to root directory:
```bash
mvnw spring-boot:run
```
or
```bash
mvnw clean package 
java -jar target/<name>.jar
```

## Links
http://localhost:8080/api/samples
http://localhost:8080/swagger-ui/index.html
