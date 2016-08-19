import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

	static InputStream is;

	public static void main(String[] args) {
		is = System.in;

		StringBuilder res = new StringBuilder();
		int t = ni();
		for (int k = 0; k < t; k++) {
			int price = ni();
			int n = ni();
			Integer[] money = new Integer[n + 1];
			for (int j = 1; j < money.length; j++) {
				money[j] = ni();
			}
			money[0] = 0;
			Arrays.sort(money);

			long[][] totalMoney = new long[n + 1][price + 1];
			int[][] count = new int[n + 1][price + 1];

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < price + 1; j++) {
					long value;
					int cnt;
					if(money[i]>=j){
						value = money[i];
						cnt =1;
					}else{
						value = money[i] + totalMoney[i-1][j - money[i]];
						cnt = count[i-1][j - money[i]]+1;
					}
					if(value >=j && totalMoney[i-1][j]>=j){
						if(value <= totalMoney[i-1][j] && cnt <= count[i-1][j]){
							totalMoney[i][j] = value;
							count[i][j] = cnt;
						}else{
							totalMoney[i][j] = totalMoney[i-1][j];
							count[i][j] = count[i-1][j];
						}
					}else{
						if(value <j && totalMoney[i-1][j]<j){
							totalMoney[i][j] = value;
							count[i][j] = cnt;
						}else{
							if(value >=j){
								totalMoney[i][j] = value;
								count[i][j] = cnt;
							}else{
								totalMoney[i][j] = totalMoney[i-1][j];
								count[i][j] = count[i-1][j];
							}
						}
					}
				}
			}

			// if (price == 0) {
			// res.append(money[1] + " 1\n");
			// continue;
			// }
			res.append(totalMoney[n][price] + " " + count[n][price] + "\n");
		}

		System.out.print(res);
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
