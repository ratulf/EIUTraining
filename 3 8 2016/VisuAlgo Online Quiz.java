import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static InputStream is;

	public static void main(String[] args) {
		is = System.in;

		int v = ni();
		int e = ni();
		List<Edge>[] list = new List[v]; 
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < e; i++) {
			int a = ni();
			int b = ni();
			int c = ni();
			list[a].add(new Edge(b,c));
			//list[b].add(new Edge(a,c));
		}
		int start = ni();
		int end = ni();	
		boolean[] visited = new boolean[v];
		long[] shortest = new long[v];
		int[] count = new int[v];
		count[start] =1;
		Arrays.fill(shortest, Long.MAX_VALUE);
		shortest[start] =0;
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(start,0));
		
		while(!queue.isEmpty()){
			Edge currentEdge = queue.poll();
			if(visited[currentEdge.vertex]) continue;
			visited[currentEdge.vertex] = true;
			
			for (Edge nextEdge : list[currentEdge.vertex]) {
				long nextWeight = shortest[currentEdge.vertex] + nextEdge.weight;
				if(nextWeight <= shortest[nextEdge.vertex]){
					if(nextWeight == shortest[nextEdge.vertex]){
						count[nextEdge.vertex]+= count[currentEdge.vertex];
					}else{
						count[nextEdge.vertex] = count[currentEdge.vertex];
					}
					shortest[nextEdge.vertex] = nextWeight;
					
					queue.add(new Edge(nextEdge.vertex, shortest[nextEdge.vertex]));
				}
			}
		}
		System.out.println(count[end]);
	}

	static class Edge implements Comparable<Edge>{
		public int vertex;
		public long weight;
		public Edge(int v, long w){
			vertex = v;
			weight = w;
		}
		@Override
		public int compareTo(Edge that) {
			if(this.weight > that.weight) return 1;
			if(this.weight < that.weight) return -1;
			return 0;
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
