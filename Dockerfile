# Use the official Tomcat image from the Docker Hub
FROM tomcat:9.0.65-jdk11-openjdk

# Set environment variables
ENV JAVA_OPTS="-Dspring.profiles.active=prod"

# Copy the WAR file to the webapps directory of Tomcat
COPY target/HospitalManagement.war /usr/local/tomcat/webapps/

# Expose the port on which Tomcat is running
EXPOSE 8081

# Run Tomcat
CMD ["catalina.sh", "run"]
