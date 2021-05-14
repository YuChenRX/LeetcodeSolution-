public class demo1 {
    static int a(int i) {
        if (i == 1) return 1;
        if (i == 0) return 0;
        return a(i - 1) + a(i - 2);
    }

    public static void main(String[] args) {//青蛙跳台阶
        System.out.println(a(2));
    }
}
