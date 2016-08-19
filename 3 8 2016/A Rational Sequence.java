import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		StringBuilder res = new StringBuilder();
		int n = ni();
		for (int i = 0; i < n; i++) {
			int c = ni();
			String[] in = ns().split("/");
			int top = Integer.parseInt(in[0]);
			int bot = Integer.parseInt(in[1]);
			long topRes =0;
			long botRes =0;
			if(bot == 1){
				topRes = bot;
				botRes = top+1;
			}else{
				if(top<bot){
					topRes = bot;
					botRes = bot - top;
				}else{
					topRes =bot;
					int div = top/bot;
					botRes = bot -(top - div*bot) + (bot*div);
				}
			}
			res.append(c + " " + topRes + "/" + botRes+"\n");
		}
		System.out.print(res);
	}

	static InputStream input = System.in;
	static byte[] tokens = new byte[4096];
	static int length = 0, count = 0;

	static int readByte() {
		if (length == -1)
			throw new InputMismatchException();
		if (count >= length) {
			count = 0;
			try {
				length = input.read(tokens);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (length <= 0)
				return -1;
		}
		return tokens[count++];
	}

	static boolean hasNext() {
		return length != -1;
	}

	static boolean isSpaceChae(int b){
		return !(b >= 33 && b<=126);
	}
	
	static int skip(){
		int b;
		while((b = readByte()) != -1 && isSpaceChae(b)){
		}
		return b;
	}
	
	static String ns(){
		int b = skip();
		StringBuilder res = new  StringBuilder();
		while(!isSpaceChae(b)){
			res.appendCodePoint(b);
			b = readByte();
		}
		return res.toString();
	}
	
	static long nl() {
		long res = 0;
		int b;
		boolean isNegative = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			isNegative = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				res = res * 10 + (b - 48);
			} else {
				return isNegative ? -res : res;
			}
			b = readByte();
		}
	}
	
	static int ni() {
		int res = 0;
		int b;
		boolean isNegative = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			isNegative = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				res = res * 10 + (b - 48);
			} else {
				return isNegative ? -res : res;
			}
			b = readByte();
		}
	}
}
