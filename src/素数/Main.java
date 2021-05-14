package 素数;

public class Main {
    public static int getPrime(int x) {
        if(x<=2)return x;
        boolean[] m = new boolean[x];
        int count = 0;
        for (int i = 2; i < x; i++) {
            if (!m[i]) {
                count++;
                for (int j = i; j < x; j+=i) {
                    m[j]=true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("--"+getPrime(1));
    }
}
