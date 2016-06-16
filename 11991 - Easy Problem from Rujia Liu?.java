
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[]args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        while (sc.ready())
        {
            int n = sc.nextInt() , m = sc.nextInt();
            ArrayList<Integer> adjList [] = new ArrayList[((int)1e6) + 2];
            for(int i= 0 ; i < ((int)1e6) + 2 ; ++i) adjList[i] = new ArrayList<>();
            for(int i = 1 ; i <= n ; ++i) adjList[sc.nextInt()] .add(i) ;
            while (m-- > 0)
            {
                int occ = sc.nextInt() , val = sc.nextInt();
                if (adjList[val].size() < occ)
                    out.printf("%d\n" , 0);
                else out.printf("%d\n" , adjList[val].get(occ - 1));
            }
        }
        out.flush();
        out.close();
    }

    static public class FenwickTree { // one-based DS

        int n;
        int[] ft;

        FenwickTree(int size) {
            n = size;
            ft = new int[n + 1];
        }

        int rsq(int b) //O(log n)
        {
            int sum = 0;
            while (b > 0) {
                sum += ft[b];
                b -= b & -b;
            }        //min?
            return sum;
        }

        int rsq(int a, int b) {
            return rsq(b) - rsq(a - 1);
        }

        void point_update(int k, int val)    //O(log n), update = increment
        {
            while (k <= n) {
                ft[k] += val;
                k += k & -k;
            }        //min?
        }
    }

    static  class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }

        public boolean ready() throws IOException {return br.ready();}


    }

}
