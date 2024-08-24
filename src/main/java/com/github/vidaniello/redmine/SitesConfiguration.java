package com.github.vidaniello.redmine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

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
	

	
	public void saveToDefaultLocation() throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		File confFile = getDefaultConfigFile();
		FileOutputStream fos = new FileOutputStream(confFile);
		ByteArrayInputStream bais = new ByteArrayInputStream(json.getBytes());
		IOUtils.copy(bais, fos);
		fos.close();
		bais.close();
	}
	
	private static File getDefaultConfigFile() throws IOException {
		File confPath = new File(defaultConfigPath);
		confPath.mkdirs();
		File confFile = new File(defaultConfigPath+defaultConfigFileName);
		if(!confFile.exists())
			confFile.createNewFile();
		return confFile;
	}
		
	public static SitesConfiguration getFromDefaultLocation() throws Exception {
		File defConfFile = getDefaultConfigFile();
		if(defConfFile.length()<=0)
			throw new Exception("Empty config file");
		FileInputStream fis = new FileInputStream(defConfFile);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copy(fis, baos);
		String json = new String(baos.toByteArray());
		fis.close();
		baos.close();
		Gson gson = new Gson();
		return gson.fromJson(json, SitesConfiguration.class);
	}
	
	public static SitesConfiguration getDefaultBaseConfiguration() {
		SitesConfiguration ret = new SitesConfiguration();
		
		RedmineConfiguration rc1 = new RedmineConfiguration();
		rc1.setDescripton("Description");
		rc1.setApiKey("apikey");
		rc1.setInstanceUri("http://redmineserver");
		
		ret.getRedmineConfigurations().add(rc1);
		
		return ret;
	}
}
