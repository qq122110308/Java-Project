package com.ry.utils;


/**
 * <p>
 * 类名: FileUtil
 * </p>
 * <p>
 * 描述: 文件工具类
 * </p>
 */
public class FileUtil {
	/**
	 * 描述: 取当前项目路径
	 * 
	 * @return
	 */
	public String getBaseDir() {
		String path = getClass().getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(1, path.indexOf("WEB-INF/"));
		}
		return path;
	}
}
