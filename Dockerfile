FROM tomcat:9.0

# Remove default ROOT application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Add your WAR file to Tomcat's webapps directory
COPY target/HospitalManagement.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
