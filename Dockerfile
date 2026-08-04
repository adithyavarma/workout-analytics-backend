# Use Eclipse Temurin JDK 20 (official OpenJDK build)
FROM eclipse-temurin:20-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

RUN ./mvnw --version

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the JAR (use wildcard so you don't need exact name)
CMD ["bash", "-c" , "java -jar target/*.jar"]
