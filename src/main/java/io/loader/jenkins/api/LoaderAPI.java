package io.loader.jenkins.api;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import javax.servlet.ServletException;

import net.sf.json.JSONException;

import org.apache.http.impl.client.DefaultHttpClient;

public class LoaderAPI {
	
	PrintStream logger = new PrintStream(System.out);
	DefaultHttpClient httpClient;
	String apiKey;

	public LoaderAPI(String apiKey) {
		this.apiKey = apiKey;
        try {
            httpClient = new DefaultHttpClient();
        } catch (Exception ex) {
            logger.format("error Instantiating HTTPClient. Exception received: %s", ex);
        }
    }
	
	public HashMap<String, String> getTestList() {
		return null;
	}
	
	public Boolean getTestApi() throws JSONException, IOException, ServletException {
		if (apiKey == null || apiKey.trim().isEmpty()) {
            logger.println("getTestApi apiKey is empty");
            return false;
        }
		return true;
    }

}
