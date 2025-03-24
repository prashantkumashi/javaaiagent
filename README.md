# Java AI Agents

This repository contains Java-based AI agent projects. It includes two key scenarios:

## Scenarios

### 1. Simple Conversational Agent

This scenario involves a basic conversational agent that can respond to user queries using the OpenAI API.

- **Test Class**: `ChatControllerTest`
- **Description**: Contains tests for simple and complex questions, verifying responses using the OpenAI GPT-4 model.

### 2. Embedding-Based Agent

This scenario leverages embeddings to enhance the agent's capabilities, such as understanding context and making more informed responses.

- **Test Class**: `EmbeddingControllerTest`
- **Description**: Contains tests for the embedding functionalities, ensuring correct integration with the OpenAI API.

## Environment Variables

To run the project, three environment variables must be set:

- `OPENAI_API_KEY`: The API key for accessing OpenAI services.
- `OPENAI_ORG_ID`: The organization ID associated with the OpenAI account.
- `OPENAI_PROJECT_ID`: The project ID for the specific OpenAI project.

These variables are required for the application to authenticate and interact with the OpenAI API.

## Key Files

- **.github/workflows/maven.yml**: Configures the GitHub Actions CI/CD pipeline, including setting up the necessary environment variables.
- **src/test/java/com/pck/genai/controller/ChatControllerTest.java**: Contains tests for the simple conversational agent.
- **src/test/java/com/pck/genai/controller/EmbeddingControllerTest.java**: Contains tests for the embedding-based agent.

## Running the Project

Ensure that the environment variables are correctly set in the GitHub repository secrets or locally before running the project. The Maven build process will use these variables to interact with the OpenAI API during tests and runtime.

``` ▋
