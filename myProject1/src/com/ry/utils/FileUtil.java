package com.ry.utils;


/**
 * <p>
 * ����: FileUtil
 * </p>
 * <p>
 * ����: �ļ�������
 * </p>
 */
public class FileUtil {
	/**
	 * ����: ȡ��ǰ��Ŀ·��
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
