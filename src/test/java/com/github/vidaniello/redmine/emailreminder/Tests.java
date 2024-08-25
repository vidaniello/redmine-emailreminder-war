package com.github.vidaniello.redmine.emailreminder;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.vidaniello.redmine.SitesConfiguration;
import com.github.vidaniello.redmine.UtilApp;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Project;

public class Tests {
	
	static {
		// Log4j from 2.17.>, use this if the config file is not under ssl socket
		//System.setProperty("log4j2.Configuration.allowedProtocols", "http");

		// URL file di configurazione Log4j2
		System.setProperty("log4j.configurationFile",
				"https://gist.github.com/vidaniello/c20e29cdffb407ec5d3c773fb92786b9/raw/92c8e809f51133ef56e4867a6cabb0744ee6b9b6/log4j2.xml");

		// Tips per java.util.logging
		System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");

		// private org.apache.logging.log4j.Logger log =
		// org.apache.logging.log4j.LogManager.getLogger();
	}
	
	private Logger log = LogManager.getLogger();
	
	@Test
	public void testWriteAndReadConfiguration() {
		try {
			
			SitesConfiguration sc = SitesConfiguration.getEmptySitesConfiguration();
			
			sc.saveToDefaultLocation();
			
			SitesConfiguration sc1 = SitesConfiguration.getFromDefaultLocation();
			
			Assertions.assertTrue(sc.getRedmineConfigurations().size()==sc1.getRedmineConfigurations().size());
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
	@Test
	public void testGetAllProjects() {
		try {
			
			Collection<RedmineManager> rms = UtilApp.getAllRedmineManager();
			
			for(RedmineManager rm : rms) {
				
				List<Project> allProjects = rm.getProjectManager().getProjects();
				
			}
			
			int i = 0;
			
		}catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

}
