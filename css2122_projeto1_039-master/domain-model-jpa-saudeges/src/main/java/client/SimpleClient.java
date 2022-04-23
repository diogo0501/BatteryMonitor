package client;

import facade.exceptions.ApplicationException;
import facade.startup.SaudeGesSys;

public class SimpleClient {
	
	private SimpleClient() {
	}

    public static void main(String[] args) {

    	SaudeGesSys app = new SaudeGesSys();
        try {
            app.run();
            
            // TODO
            
            app.stopRun();
        } catch (ApplicationException e) {

        	e.printStackTrace();
        }
    }
}