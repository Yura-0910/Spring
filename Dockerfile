FROM eclipse-temurin:latest
COPY target/*.jar /SpringSecurity.jar
#ENV PROFILE=dev
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/SpringSecurity.jar","--spring.profiles.active=${PROFILE}"]
ENTRYPOINT ["java","-jar","/SpringSecurity.jar"]
