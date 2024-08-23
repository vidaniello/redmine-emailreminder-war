package com.github.vidaniello.redmine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SitesConfiguration {
	
	public static String defaultConfigPath = System.getProperty("user.home")+File.separator+"vidaniello-redmine"+File.separator;
	public static String defaultConfigFileName = "sitesConfiguration.json";
	
	private List<RedmineConfiguration> redmineConfigurations;

	
	public SitesConfiguration() {
		
	}
	
	public List<RedmineConfiguration> getRedmineConfigurations() {	
		if(redmineConfigurations==null)
			redmineConfigurations = new ArrayList<>();
		return redmineConfigurations;
	}
	
	private File getDefaultConfigFile() throws IOException {
		File confPath = new File(defaultConfigPath);
		confPath.mkdirs();
		File confFile = new File(defaultConfigPath+defaultConfigFileName);
		if(!confFile.exists())
			confFile.createNewFile();
		return confFile;
	}
	
	public void saveDefaultLocation() {
		
	}
}
