package az.medium.keycloak.registration;

import org.keycloak.Config;
import org.keycloak.authentication.FormAction;
import org.keycloak.authentication.FormActionFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;

public class YourFormActionFactory implements FormActionFactory {

    @Override
    public String getId() {
        return "your-id";
    }

    @Override
    public String getDisplayType() {
        return "Your Description";
    }

    @Override
    public String getReferenceCategory() {
        return "Your Category";
    }

    @Override
    public String getHelpText() {
        return "Your Help Text";
    }

    @Override
    public boolean isConfigurable() {
        return false;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        AuthenticationExecutionModel.Requirement[] requirements =
                new AuthenticationExecutionModel.Requirement[2];
        requirements[0] = AuthenticationExecutionModel.Requirement.REQUIRED;
        requirements[1] = AuthenticationExecutionModel.Requirement.DISABLED;
        return requirements;
    }

    @Override
    public boolean isUserSetupAllowed() {
        return false;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return List.of();
    }

    @Override
    public FormAction create(KeycloakSession keycloakSession) {
        return new YourFormAction();
    }

    @Override
    public void init(Config.Scope scope) {
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {
    }

    @Override
    public void close() {
    }
}
