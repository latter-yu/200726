import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main1(String[] args) {

        // 给定一个数字 arr
        // 其中只有有两个数字出现了奇数次，其它数字都出现了偶数次
        // 按照从小到大顺序输出这两个数。

        // 输入描述:
        // 输入包含两行，第一行一个整数 n (1 <= n <= 10^5) 代表数组 arr 的长度
        // 第二行 n 个整数，代表数组 arr, arr[i] 为 32 位整数。
        // 输出描述:
        // 输出出现奇数次的两个数，按照从小到大的顺序。

        // 示例:
        // 输入
        // 4
        // 1 1 2 3
        // 输出
        // 2 3
        // 示例:
        // 输入
        // 6
        // 11 22 11 23 23 45
        // 输出
        // 22 45

        // 备注:
        // 时间复杂度 O(n), 额外空间复杂度 O(1)。

        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
            }
            int[] num = new int[2];
            int cur = 0;
            for (Integer m : map.keySet()) {
                if (map.get(m) % 2 != 0) {
                    num[cur++] = m;
                }
            }
            Arrays.sort(num);
            System.out.println(num[0] + " " + num[1]);
        }
    }

    public static void main2(String[] args) {

        // 给定一个可能含有重复值的数组 arr
        // 找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。
        // 返回所有位置相应的信息。

        // 输入描述:
        // 第一行输入一个数字 n，表示数组 arr 的长度。
        // 以下一行输入 n 个数字，表示数组的值
        // 输出描述:
        // 输出 n 行，每行两个数字 L 和 R
        // 如果不存在，则值为 -1，下标从 0 开始。
        // 示例:
        // 输入
        // 7
        // 3 4 1 5 6 2 7
        // 输出
        // -1 2
        // 0 2
        // -1 -1
        // 2 5
        // 3 5
        // 2 -1
        // 5 -1

        // 75% 通过率
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] num = new int[2];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    num[0] = -1;
                } else {
                    for (int j = i; j >= 0; j--) {
                        if (arr[j] < arr[i]) {
                            num[0] = j;
                            break;
                        }
                        num[0] = -1;
                    }
                }
                for (int j = i; j < n; j++) {
                    if (arr[j] < arr[i]) {
                        num[1] = j;
                        break;
                    }
                    num[1] = -1;
                }
                System.out.println(num[0] + " " + num[1]);
            }
        }
    }

    public static void main(String[] args) {

        // 牛牛想尝试一些新的料理，每个料理需要一些不同的材料
        // 问完成所有的料理需要准备多少种不同的材料。

        // 输入描述:
        // 每个输入包含 1 个测试用例。
        // 每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料
        // 各个材料用空格隔开，输入只包含大写英文字母和空格
        // 输入文件不超过 50 行，每一行不超过 50 个字符。
        // 输出描述:
        // 输出一行一个数字表示完成所有料理需要多少种不同的材料。

        // 示例:
        // 输入
        // BUTTER FLOUR
        // HONEY FLOUR EGG
        // 输出
        // 4

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            // 测试用例只有一个，但会输出多行
            String strs = sc.next();
            String[] str = strs.split(" ");
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])) {
                    map.put(str[i], map.get(str[i]) + 1);
                } else {
                    map.put(str[i], 1);
                }
            }
        }
        int count = 0;
        for (String m : map.keySet()) {
            count++;
        }
        System.out.println(count);
    }
}

