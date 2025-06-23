# Spring Boot Azure Deployment

A Spring Boot application configured for automatic deployment to Azure Web Service using GitHub Actions.

## Features

- Java 17
- Spring Boot 3.2.1
- RESTful API with `/hello` endpoint
- Health check endpoints via Spring Actuator
- Automated testing
- GitHub Actions CI/CD pipeline for Azure deployment

## API Endpoints

- `GET /hello` - Returns `{"hello": "world"}`
- `GET /actuator/health` - Health check endpoint
- `GET /actuator/info` - Application information

## Local Development

### Prerequisites

- Java 17
- Maven 3.6+

### Running the Application

```bash
# Build the application
mvn clean compile

# Run tests
mvn test

# Start the application
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## Azure Deployment Setup

### Prerequisites

1. **Azure Web App**: Create an Azure Web App with Java 17 runtime
2. **Publish Profile**: Download the publish profile from Azure portal
3. **GitHub Secrets**: Add the publish profile as a secret

### GitHub Secrets Configuration

1. Go to your GitHub repository settings
2. Navigate to Secrets and Variables > Actions
3. Add the following secret:
   - `AZUREAPPSERVICE_PUBLISHPROFILE`: Paste the contents of your downloaded publish profile

### Workflow Configuration

Update the following values in `.github/workflows/azure-deploy.yml`:

```yaml
env:
  AZURE_WEBAPP_NAME: your-actual-app-name  # Replace with your Azure Web App name
```

### Deployment Process

1. Push code to the `main` branch
2. GitHub Actions will automatically:
   - Build the application
   - Run tests
   - Package the JAR file
   - Deploy to Azure Web App

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/springbootazure/
│   │       ├── SpringBootAzureApplication.java
│   │       └── controller/
│   │           └── HelloController.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/example/springbootazure/
            ├── SpringBootAzureApplicationTests.java
            └── controller/
                └── HelloControllerTest.java
```

## Testing

```bash
# Run all tests
mvn test

# Test the hello endpoint locally
curl http://localhost:8080/hello
```

Expected response:
```json
{"hello": "world"}
```

## Monitoring

Once deployed, you can monitor your application using:

- Azure Application Insights (if configured)
- Spring Boot Actuator endpoints:
  - `/actuator/health` - Application health status
  - `/actuator/info` - Application information