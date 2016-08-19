import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {
	static InputStream is;

	public static void main(String[] args) {
		is = System.in;

		int n = ni();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			long a = nl();
			long b = nl();
			String prop = ns();
			long aa = nl();
			long bb = nl();
			long topRes = 0;
			long botRes = 0;

			switch (prop) {
			case "+": {
				topRes = a * bb + aa * b;
				botRes = b * bb;
			}
				break;
			case "-": {
				topRes = a * bb - aa * b;
				botRes = b * bb;
			}
				break;
			case "*": {

				topRes = a * aa;
				botRes = b * bb;
			}
				break;
			case "/": {
				topRes = a * bb;
				botRes = b * aa;
			}
				break;
			default:
				break;
			}

			long gcd = GCD(topRes, botRes);
			topRes = topRes / gcd;
			botRes = botRes / gcd;
			if ((topRes < 0 && botRes < 0) || botRes < 0) {
				topRes = -topRes;
				botRes = -botRes;
			}
			res.append(topRes + " / " + botRes + "\n");
		}
		System.out.print(res);
	}

	static long GCD(long a, long b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
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
