package com.CallCenter.master.config;

import javax.servlet.http.HttpServletRequest;

public class Utility {

	public static String getSitrURL(HttpServletRequest request) {
		String siteURL = request.getRequestURI().toString();
		return siteURL.replace(request.getServletPath(), "");
	}
}
