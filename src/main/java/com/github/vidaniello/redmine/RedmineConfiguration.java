package com.github.vidaniello.redmine;

public class RedmineConfiguration {
	
	private String descripton;
	private String apiKey;
	private String instanceUri;
	
	public RedmineConfiguration() {
		
	}
	
	public String getDescripton() {
		return descripton;
	}
	
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public String getInstanceUri() {
		return instanceUri;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public void setInstanceUri(String instanceUri) {
		this.instanceUri = instanceUri;
	}

}
