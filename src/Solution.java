import java.util.Arrays;

class Solution {
    private static boolean HaveChar(char C,int Index) {
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        char []s2Temp=s2.toCharArray();//需要贪心算法
        Arrays.sort(s2Temp);
        s2=String.copyValueOf(s2Temp);
        System.out.println(s1);
        for (int i = 0; i < s2.length(); i++) {
            System.out.print(s2.charAt(i));
        }
        System.out.println();

        return false;
    }

    public static void main(String[] args) {//Char at i 如果返回false 就下跑i++也就是找第i+1个‘a’
        String s1=new String("bacd");
        String s2=new String("ab");
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
