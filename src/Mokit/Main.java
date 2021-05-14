package Mokit;

import java.util.Scanner;

class Main {
    static void _3102() {// TODO: 3102
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < count; i++) {
            ret ^= nums[i];
        }
        System.out.println(ret);
    }

    static void _2873() {
        Scanner sc = new Scanner(System.in);
        int stepNums = sc.nextInt();
        if (stepNums == 1) System.out.print(1);
        else if (stepNums == 2) System.out.print(2);
        else if (stepNums == 3) System.out.print(4);
        else {
            long[] dp = new long[stepNums + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
            }
            System.out.println(dp[stepNums]);
        }
    }

    static void _2793() {//9 -8
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[sc.nextInt()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int left = 0;
        int right = 0;
        int maxValue = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {//累加
            if (nums[i] + max >= 0) {
                right++;
                max += nums[i];
            } else {
                left = i;
                max = nums[i];
            }
            if (maxValue < max) maxValue = max;
        }
        //[)
        //[
        System.out.println(maxValue + " " + (left + 1) + " " + (right - 1));
    }

    static void aVoid(int[] arr) {
        int maxSum = Integer.MIN_VALUE; //很重要，初始值赋值为负无穷大
        int sum = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (sum < 0) {//小于0则舍弃
                sum = arr[i];
                left = i;
                right = left;
            } else {
                sum += arr[i];
                right++;
            }
            if (sum > maxSum) {//比现有最大值大，则替换
                maxSum = sum;
            }
        }
        System.out.println(left + 1 + "\t" + (right - 1));
        System.out.println(maxSum);
    }

    public static void numberTriangle() {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int n = 2;
        int ret = 0;
        int[][] map = new int[2][row];
        int[][] dp = new int[2][row];
        map[0][0] = sc.nextInt();
        dp[0][0] = map[0][0];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < n; j++) {
                map[i % 2][j] = sc.nextInt();
                if (j == 0) dp[i % 2][j] = map[i % 2][j] + dp[i % 2 - 1 == -1 ? 1 : 0][j];
                if (j > 0) {//
                    dp[i % 2][j] = Math.max(dp[i % 2 - 1 == -1 ? 1 : 0][j - 1] + map[i % 2][j], dp[i % 2 - 1 == -1 ? 1 : 0][j] + map[i % 2][j]);
                }
                ret = Math.max(dp[i % 2][j], ret);
            }
            n++;
        }
        System.out.println(ret);
    }



    static void _2473() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        System.out.println(dp[dp.length - 1]);
    }

    //    public static int lengthOfLIS(int[] nums) {
//        int curr=1;
//        int last=0;
//        int head=0;
//        int max=0;
//        int ret=0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[curr]>nums[last]){
//                max++;
//            }else if(nums[curr]<nums[last]&&nums[curr]<nums[head]){
//                head=curr;
//                max=0;
//            }else if(nums[nums[curr]<nums[last]&&nums)
//        }
//        ret=Math.max(ret,max);
//        return ret;
//    }

    static void _2253() {
        Scanner sc = new Scanner(System.in);
        StringBuffer ret = new StringBuffer();
        int dataNums = sc.nextInt();
        for (int i = 0; i < dataNums; i++) {// x组数据
            int arrLength = sc.nextInt();// 每一组数据的长度
            int[] house = new int[arrLength]; //data
            int[] dp = new int[house.length];
            for (int j = 0; j < arrLength; j++) {//save
                house[j] = sc.nextInt();
            }
            //解题
            dp[0] = house[0];
            dp[1] = Math.max(house[1], house[0]);
            for (int j = 2; j < dp.length; j++) {
                dp[j] = Math.max(dp[j - 2] + house[j], house[j - 1]);
            }
            ret.append(dp[dp.length - 1] + " ");
        }
        System.out.println(ret.toString().trim());
    }

    public static int maxProfit(int[] prices) {
        //todo 只能买两次
        int ret = 0;
        int left = 0;
        int right = 0;
        boolean flag = false;//手头上已经有一股股票了
        while (right < prices.length) {
            if (!flag) {//手上没有股票
                left = prices[left] >= prices[right] ? right : left;
                flag = true;
            }
            //扩充一下数组，防止越界 补【end-1】的值 股票总价值不变
            //股票不涨了
            else if (prices[right] - prices[left] > 0) {//todo =0？应该不卖叭
                if (right + 1 < prices.length && prices[right] > prices[right + 1] || right + 1 >= prices.length && prices[right] - prices[left] > 0) {//todo >=
                    System.out.println(prices[right] - prices[left]);
                    ret += prices[right] - prices[left];
                    flag = false;
                    left = right;
                    right++;
                    continue;
                }
            } else {//股票跌了
                left = right;
            }
            if (flag) right++;
        }
        return ret;
    }

    public static void _2254() {
        //几组数据
        //一组的长度
        //接受数据
        Scanner sc = new Scanner(System.in);
        int groupData = sc.nextInt();
        StringBuffer printAnswer = new StringBuffer();
        for (int i = 0; i < groupData; i++) {
            int dataLength = sc.nextInt();
            int[] data = new int[dataLength];
            for (int j = 0; j < data.length; j++) {
                data[j] = sc.nextInt();
            }
            //解决题目
            int[] retTemp = new int[2];
            //todo 只能买两次
            int ret = 0;
            int left = 0;
            int right = 0;
            boolean flag = false;//手头上已经有一股股票了
            while (right < data.length) {
                if (!flag) {//手上没有股票
                    left = data[left] >= data[right] ? right : left;
                    flag = true;
                }
                //扩充一下数组，防止越界 补【end-1】的值 股票总价值不变
                //股票不涨了
                else if (data[right] - data[left] > 0) {//todo =0？应该不卖叭
                    if (right + 1 < data.length && data[right] > data[right + 1] || right + 1 >= data.length && data[right] - data[left] > 0) {//todo >=
                        ret = data[right] - data[left];
                        flag = false;
                        left = right;
                        right++;
                        // 对retTemp中临时存储的数据进行对比，替换
                        int a = retTemp[0] < retTemp[1] ? retTemp[0] < ret ? retTemp[0] = ret : 0 : retTemp[1] < ret ? retTemp[1] = ret : 0;
                        continue;
                    }
                } else {//股票跌了
                    left = right;
                }
                if (flag) right++;
            }
            //解决一题
            //存放答案
            printAnswer.append(retTemp[0] + retTemp[1] + " ");
        }
        System.out.println(printAnswer.toString().trim());
    }

    public static void _2255() {
        Scanner sc = new Scanner(System.in);
        int questionNums = sc.nextInt();
        int M = 0;
        int N = 0;
        for (int i = 1; i < questionNums; i++) {
            M = sc.nextInt();//all
            N = sc.nextInt();//分割
            int[][] dp = new int[M][N];
            //dp 初始化
            for (int j = 0; j < dp.length; j++) {//todo
                dp[0][j] = 0;
                dp[j][0] = 0;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {

                }
            }
        }
    }

    public static void _558() {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr.length == 1) {
            System.out.println(1);
            return;
        } else if (arr.length == 2) {
            System.out.println((arr[0] > arr[1] ? "2" : "1"));
            return;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            dp[i] = arr[i - 1] - arr[i] + arr[i + 1] - arr[i];
        }
        dp[dp.length - 1] = arr[arr.length - 2] - arr[arr.length - 1];
        int ret = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] < dp[ret]) ret = i;
        }
        System.out.println(ret + 1);
    }

    public static void __3487(){
        Scanner cin = new Scanner(System.in);
        int arrLength=cin.nextInt();
        int limit=0;
        int[] arr=new int[arrLength];

        int[] dp=new int[arrLength+1];
        //save data
        for(int i=0;i<arr.length;i++){
            arr[i]=cin.nextInt();
        }
        //init
        dp[dp.length-1]=arr[arr.length-1];

        for(int i=dp.length-2;i>=1;i--){
            if(arr[i-1]>dp[i+1]||i-2>=0&&arr[i-1]<arr[i-2]){
                dp[i]=arr[i-1]+dp[i+1];
                limit++;
            }else {
                dp[i]=arr[i-1];
            }
        }

        cin.close();
        System.out.println(limit);
    }

    public static void main(String[] args) {

//        Random random = new Random();
//        IntStream ints = random.ints(10, 20).distinct().limit(10);
//        ints.forEach(System.out::println);
    }
}
