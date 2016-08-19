import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class Main {
	static InputStream is;

	public static void main(String[] args) {
		is = System.in;
		int[] price = new int[4];
		price[1] = ni();
		price[2] = ni();
		price[3] = ni();

		ArrayList<ParkingTime> times = new ArrayList<ParkingTime>();
		for (int i = 0; i < 3; i++) {
			int inTime = ni();
			int outTime = ni();
			times.add(new ParkingTime(inTime, true));
			times.add(new ParkingTime(outTime, false));
		}
		Collections.sort(times);
		int currentCars = 0;
		int previousTime = 0;
		int sum = 0;
		for (int i = 0; i < times.size(); i++) {
			ParkingTime car = times.get(i);
			if (car.isIn) {
				if (car.time != previousTime) {
					sum += (car.time - previousTime) * currentCars
							* price[currentCars];
					previousTime = car.time;
					currentCars += 1;
				} else {
					currentCars++;
				}
			} else {
				sum += (car.time - previousTime) * currentCars
						* price[currentCars];
				previousTime = car.time;
				currentCars--;
			}
		}
		System.out.println(sum);
	}

	static class ParkingTime implements Comparable<ParkingTime> {
		public int time;
		public boolean isIn;

		public ParkingTime(int time, boolean isIn) {
			this.time = time;
			this.isIn = isIn;
		}

		@Override
		public int compareTo(ParkingTime that) {
			// TODO Auto-generated method stub
			return this.time - that.time;
		}
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/
	static byte[] inbuf = new byte[4096];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}
