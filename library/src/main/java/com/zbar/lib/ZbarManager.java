package com.zbar.lib;
/**
*zbar调用类
*@author TLJ
*created at 2016/9/19 14:50
*QQ:172864659
*/
public class ZbarManager {

	static {
		System.loadLibrary("zbar");
//		System.loadLibrary("iconv");
	}

	public native String decode(byte[] data, int width, int height, boolean isCrop, int x, int y, int cwidth, int cheight);
}
