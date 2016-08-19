import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static InputStream is;
	static StringBuilder res = new StringBuilder();
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n;
		
		while ((n = in.nextInt()) != 0) {
			String[] input = new String[n];
			int maxLength = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				input[i] = in.nextLine();
				if (input[i].length() > maxLength) {
					maxLength = input[i].length();
				}
			}
			for (int i = 0; i < maxLength; i++) {
				int spaceCount =0;
				for (int j = n-1; j >=0 ; j--) {
					if (i < input[j].length()) {
						if (input[j].charAt(i) == '-') {
							insertSpace(spaceCount);
							res.append("|");
							spaceCount = 0;
						} else {
							if (input[j].charAt(i) == '|') {
								insertSpace(spaceCount);
								res.append("-");
								spaceCount =0;
							} else {
								if(input[j].charAt(i) == '+'){
									insertSpace(spaceCount);
									res.append("+");
									spaceCount =0;
								}else{
									spaceCount++;
								}
								
							}
						}
					} else {
						spaceCount++;
					}
				}
				res.append("\n");
			}
			res.append("\n");
		}
		System.out.print(res.deleteCharAt(res.length()-1));

	}
	static void insertSpace(int n){
		for (int i = 0; i < n; i++) {
			res.append(" ");
		}
	}
	
}
class InputReader {
	StringTokenizer tokenizer;
	BufferedReader reader;

	public InputReader(InputStream stream) {
		tokenizer = null;
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
	}

	public String next() {
		while ((tokenizer == null) || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
	public String nextLine(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

