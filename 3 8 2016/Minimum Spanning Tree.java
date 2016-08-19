import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Main {
    static InputStream is;

    static int[] parent;
    public static void main(String[] args) {
        is = System.in;

        StringBuilder res = new StringBuilder();
        while (true) {
            int n = ni();
            int m = ni();
            if(n == 0 && m == 0) break;
            PriorityQueue<Edge> queue = new PriorityQueue<Main.Edge>();
            for (int i = 0; i < m; i++) {
                int u = ni(), v = ni(), w = ni();
                if(u==v) continue;
                queue.add(new Edge(u, v, w));
            }
            parent = new int[n];
            PriorityQueue<EdgeResult> qResult = new PriorityQueue<Main.EdgeResult>();
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            long sum =0;
            int count =1;
            
            while(!queue.isEmpty()){
                Edge edge = queue.poll();
                int parent1 = findParent(edge.u);
                int parent2 = findParent(edge.v);
                if(parent1 == parent2) continue;
                parent[parent1] = parent2;
                sum += edge.w;
                count ++;
                qResult.add(new EdgeResult(edge.u, edge.v));
            }
            
            if(count ==n){
                res.append(sum + "\n");
                while(!qResult.isEmpty()){
                    EdgeResult e = qResult.poll();
                    res.append(e.u + " " + e.v + "\n");
                }
            }else{
                res.append("Impossible\n");
            }

        }
        System.out.print(res);
    }
    
    static int findParent( int n){
        if(parent[n] == n) return n;
        int nextParent = parent[n];
        while(nextParent != parent[nextParent]){
            nextParent = parent[nextParent];
        }
        return nextParent;
    }
    static class Edge implements Comparable<Edge> {

        public int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge that) {

            return this.w - that.w;
        }

    }
    static class EdgeResult implements Comparable<EdgeResult>{
        public int u,v;
        public EdgeResult(int u, int v){
            if(u > v){
                this.u = v;
                this.v = u;
            }else{
                this.u = u;
                this.v = v;
            }
        }
        @Override
        public int compareTo(EdgeResult that) {
            if(this.u == that.u){
                return this.v - that.v;
            }
                return this.u - that.u;
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
