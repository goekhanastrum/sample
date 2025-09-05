# Demo sample Projekt für ISO - ITZBund ZER - RV SDM

## Erstelle Docker Netzwerk
```bash
docker network create samplenetwork
```

## Erstelle MySQL und Jenkins container mit Docker
```bash
docker run --name sample-mysql --network samplenetwork -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sampledb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -p 3306:3306 -d mysql:8.0
```
```bash
docker run -d --name Jenkins --network samplenetwork -p 8081:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts
```

## Navigiere zum root Ordner:
```bash
mvnw spring-boot:run
```
oder
```bash
mvnw clean package 
java -jar target/<name>.jar
```

## Links
http://localhost:8080/api/samples            (REST Beispiel)
http://localhost:8080/swagger-ui/index.html  (swagger)
http://localhost:8081/                       (jenkins)
