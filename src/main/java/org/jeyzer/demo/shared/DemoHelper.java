package org.jeyzer.demo.shared;


/*-
 * ---------------------------LICENSE_START---------------------------
 * Jeyzer Demo
 * --
 * Copyright (C) 2020 Jeyzer SAS
 * --
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * ----------------------------LICENSE_END----------------------------
 */


import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import javax.management.MBeanServer;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DemoHelper {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoHelper.class);
	
    private static final String HOTSPOT_BEAN_NAME = "com.sun.management:type=HotSpotDiagnostic";
    private static final String JVM_FLAG = "HeapDumpPath";
	
	private DemoHelper() {}

	// Cached random
	private static final Random random = new Random();
	
	public static int getNextRandomInt(int limit) {
		return random.nextInt(limit);
	}
	
	public static int getNextRandomInt() {
		return random.nextInt();
	}
	
	public static void updateJVMHeapDumpPathFlag() {
        try {
        	// Must use reflection on Java 9+ as the com.sun.management is not public
            Class<?> hotspotDiagClass = Class.forName("com.sun.management.HotSpotDiagnosticMXBean");
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
			Object hotspotMBean = ManagementFactory.newPlatformMXBeanProxy(server, HOTSPOT_BEAN_NAME, hotspotDiagClass);
            Method m = hotspotDiagClass.getMethod("setVMOption", String.class, String.class);
            m.invoke( hotspotMBean , JVM_FLAG, System.getProperty("java.io.tmpdir"));
        } catch (RuntimeException re) {
        	logger.error("Failed to set the JVM flag : {}", JVM_FLAG);
        	logger.error("Error is : {}", re.getMessage());
        } catch (Exception exp) {
        	logger.error("Failed to set the JVM flag : {}", JVM_FLAG);
        	logger.error("Error is : {}", exp.getMessage());
        }
	}
}
