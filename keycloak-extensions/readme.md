
# Keycloak Custom Pre- and Post-Registration Action

This repository contains the source code for implementing a custom pre- and post-registration action in Keycloak, as described in the [Medium post by Alex Zerntev](https://medium.com/@alexzerntev/how-to-create-an-auth0-like-pre-post-registration-action-in-keycloak-0f8676ee22b2).

## Overview

The provided code allows you to create a custom action in Keycloak that can be triggered during the user registration process, either before or after the registration is completed. This is similar to the pre- and post-registration actions available in Auth0, but implemented for Keycloak.

## Building the Project

To build the project, you will need [Maven](https://maven.apache.org/) installed on your machine. Maven is a build automation tool primarily used for Java projects.

### Steps to Build

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Alexzerntev/medium-examples.git
   cd medium-examples
   ```

2. **Build the project using Maven:**

   In the root directory of the project, run the following command:

   ```bash
   mvn clean install
   ```

   This command will compile the project, run tests, and package the code into a JAR file.

3. **Locate the JAR file:**

   After the build is successful, you can find the generated JAR file in the `target` directory of the project.

## Deploying to Keycloak

Once the JAR file is generated, it needs to be placed in the appropriate folder within your Keycloak installation.

### Steps to Deploy

1. **Copy the JAR file:**

   Locate the JAR file in the `target` directory (e.g., `your-project-name-1.0.0.jar`) and copy it to the following directory in your Keycloak installation:

   ```bash
   cp target/your-project-name-1.0.0.jar /path/to/keycloak/providers/
   ```

   Replace `/path/to/keycloak/` with the actual path to your Keycloak installation.

2. **Restart Keycloak:**

   After copying the JAR file, restart your Keycloak server to load the new provider:

   ```bash
   ./bin/kc.sh stop
   ./bin/kc.sh start
   ```

   For older versions of Keycloak, you may use `standalone.sh` instead of `kc.sh`.

3. **Verify Deployment:**

   Log in to the Keycloak admin console and navigate to **Manage > Authentication**. Your custom action should now be available in the list of actions that can be configured for user registrations.

## Additional Information

For more details on the implementation and usage of this custom action, please refer to the original [Medium article](https://medium.com/@alexzerntev/how-to-create-an-auth0-like-pre-post-registration-action-in-keycloak-0f8676ee22b2) by Alex Zerntev.
