package com.ry.utils;

import java.util.UUID;

public class BuildUUID {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
