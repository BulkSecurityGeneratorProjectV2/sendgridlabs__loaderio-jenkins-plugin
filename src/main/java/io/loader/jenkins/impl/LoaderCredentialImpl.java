package io.loader.jenkins.impl;

import com.cloudbees.plugins.credentials.CredentialsDescriptor;
import com.cloudbees.plugins.credentials.CredentialsScope;

import hudson.Extension;
import hudson.util.FormValidation;
import hudson.util.ListBoxModel;
import hudson.util.Secret;
import io.loader.jenkins.AbstractLoaderioCredential;
import net.sf.json.JSONException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import java.io.IOException;


public class LoaderCredentialImpl extends AbstractLoaderioCredential {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Secret apiKey;
    private final String description;

    @DataBoundConstructor
    public LoaderCredentialImpl(String apiKey, String description) {
        this.apiKey = Secret.fromString(apiKey);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Secret getApiKey() {
        return apiKey;
    }

    @Extension
    public static class DescriptorImpl extends CredentialsDescriptor {

        /**
         * {@inheritDoc}
         */
        @Override
        public String getDisplayName() {
            return Messages.LoaderCredential_DisplayName();
        }

        @Override
        public ListBoxModel doFillScopeItems() {
            ListBoxModel m = new ListBoxModel();
            m.add(CredentialsScope.GLOBAL.getDisplayName(), CredentialsScope.GLOBAL.toString());
            return m;
        }



        // Used by global.jelly to authenticate User key
        public FormValidation doTestConnection(@QueryParameter("apiKey") final String userKey) throws MessagingException, IOException, JSONException, ServletException {
            //BlazemeterApi bzm = new BlazemeterApi();
            //int testCount = bzm.getTestCount(userKey);
        	int testCount = 0;
            if (testCount <= 0) {
                return FormValidation.errorWithMarkup("User Key Invalid Or No Available Tests");
            } else {
                return FormValidation.ok("User Key Valid. " + testCount + " Available Tests");
            }
        }

    }
    
}
