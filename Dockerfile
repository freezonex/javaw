# Stage 1: Build the application using Maven
FROM maven:3.8.5-openjdk-17 as build

# Copy your source code to the container
COPY src /home/app/src
COPY pom.xml /home/app

# Set the working directory for the build
WORKDIR /home/app

# Package the application, skipping tests
RUN mvn package -DskipTests

# Stage 2: Create the image with the JAR file
FROM openjdk:17

# Copy the JAR file from the build stage to the /app directory in the image
COPY --from=build /home/app/target/app-jar-demo-wenhao-0.0.1-SNAPSHOT.jar /app/app.jar

# Set the working directory to /app
WORKDIR /app

# Expose the port your app runs on
EXPOSE 8085

# Command to run your app using the java binary
CMD ["java", "-jar", "app.jar"]
