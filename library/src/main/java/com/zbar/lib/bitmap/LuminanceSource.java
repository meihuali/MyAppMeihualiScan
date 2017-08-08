package com.zbar.lib.bitmap;

public abstract class LuminanceSource {

	private final int width;
	private final int height;

	protected LuminanceSource(int width, int height) {
		this.width = width;
		this.height = height;
	}


	public abstract byte[] getRow(int y, byte[] row);


	public abstract byte[] getMatrix();


	public final int getWidth() {
		return width;
	}


	public final int getHeight() {
		return height;
	}


	public boolean isCropSupported() {
		return false;
	}


	public LuminanceSource crop(int left, int top, int width, int height) {
		throw new UnsupportedOperationException("This luminance source does not support cropping.");
	}


	public boolean isRotateSupported() {
		return false;
	}


	public LuminanceSource invert() {
		return new InvertedLuminanceSource(this);
	}


	public LuminanceSource rotateCounterClockwise() {
		throw new UnsupportedOperationException("这个亮度源不支持旋转90度???什么鬼");
	}


	public LuminanceSource rotateCounterClockwise45() {
		throw new UnsupportedOperationException("这个亮度源不支持旋转45度???什么鬼");
	}

	@Override
	public final String toString() {
		byte[] row = new byte[width];
		StringBuilder result = new StringBuilder(height * (width + 1));
		for (int y = 0; y < height; y++) {
			row = getRow(y, row);
			for (int x = 0; x < width; x++) {
				int luminance = row[x] & 0xFF;
				char c;
				if (luminance < 0x40) {
					c = '#';
				} else if (luminance < 0x80) {
					c = '+';
				} else if (luminance < 0xC0) {
					c = '.';
				} else {
					c = ' ';
				}
				result.append(c);
			}
			result.append('\n');
		}
		return result.toString();
	}

}
