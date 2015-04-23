package com.epam.traning.tds_test.utils;

import com.proxy.ProxyLog;

public class ProxyUtils {

	public static boolean checkRequestIsSent(ProxyLog proxyLog, String urlPattern) {

		for (String url : proxyLog.getRequestUrls()) {
			if (url.contains(urlPattern))
				return true;
		}

		return false;
	}
}
