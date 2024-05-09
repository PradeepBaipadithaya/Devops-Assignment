FROM openjdk:8
EXPOSE 8080
ADD target/HospitalManagement.war HospitalManagement.war
ENTRYPOINT ["java","-jar","/HospitalManagement.war"]
