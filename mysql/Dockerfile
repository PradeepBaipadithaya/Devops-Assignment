# Use the official MySQL image from the Docker Hub
FROM mysql:8.0

# Set environment variables
ENV MYSQL_ROOT_PASSWORD=adminroot
ENV MYSQL_DATABASE=hospital

# Copy the initialization script to the Docker container
COPY init.sql /docker-entrypoint-initdb.d/
