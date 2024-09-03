package az.medium.keycloak.registration;

import jakarta.ws.rs.core.MultivaluedMap;
import org.keycloak.authentication.FormAction;
import org.keycloak.authentication.FormContext;
import org.keycloak.authentication.ValidationContext;
import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.utils.FormMessage;

import java.util.List;

public class YourFormAction implements FormAction {
    @Override
    public void buildPage(FormContext formContext, LoginFormsProvider loginFormsProvider) {
    }

    @Override
    public void validate(ValidationContext validationContext) {
        try {
            // Your PRE REGISTRATION logic here
            // e.g. set some attribute to the session or do some http call
            // validationContext.getSession().setAttribute("someAttribute", "someValue");

            validationContext.success(); // should be called upon success
        } catch (Exception e) {
            MultivaluedMap<String, String> formData =
                    validationContext.getHttpRequest().getDecodedFormParameters();
            List<FormMessage> formMessages =
                    List.of(new FormMessage(null, "Registration failed. Please try again later."));
            validationContext.validationError(formData, formMessages);
        }
    }

    @Override
    public void success(FormContext formContext) {
        // Your POST REGISTRATION logic here
        // e.g. get the attribute from the session and set it to the user
        //        UserModel user = formContext.getUser();
        //        String someAttribute =
        //                (String) formContext.getSession().getAttribute("someAttribute");
        //        user.setAttribute("someAttribute", List.of(someAttribute));
    }

    @Override
    public boolean requiresUser() {
        return false;
    }

    @Override
    public boolean configuredFor(
            KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {
        return false;
    }

    @Override
    public void setRequiredActions(
            KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {
    }

    @Override
    public void close() {
    }
}
