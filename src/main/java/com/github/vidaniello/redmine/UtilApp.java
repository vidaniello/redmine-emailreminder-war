package com.github.vidaniello.redmine;

import java.util.Deque;
import java.util.LinkedList;

import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;

public class UtilApp {

	public static Deque<RedmineManager> getAllRedmineManager() throws Exception{
		Deque<RedmineManager> ret = new LinkedList<>();
		
		SitesConfiguration sc = SitesConfiguration.getFromDefaultLocation();
		
		for(RedmineConfiguration rc : sc.getRedmineConfigurations())
			ret.addLast(RedmineManagerFactory.createWithApiKey(rc.getInstanceUri(), rc.getApiKey()));
		
		return ret;
	}
}
