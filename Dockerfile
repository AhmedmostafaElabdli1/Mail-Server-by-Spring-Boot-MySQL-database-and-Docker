FROM openjdk:17-jdk


WORKDIR /app

COPY target/springapp.jar /app/springapp.jar

EXPOSE 8080
CMD ["java","-jar","springapp.jar"]