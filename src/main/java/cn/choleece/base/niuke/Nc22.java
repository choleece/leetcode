package cn.choleece.base.niuke;

/**
 * @author choleece
 * @Description: 给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
 * 注意：
 * 可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
 * @Date 2020-10-20 22:27
 **/
public class Nc22 {

    public static void merge(int A[], int m, int B[], int n) {
        int len = m + n - 1;
        int curA = m - 1;
        int curB = n - 1;

        while (curA >=0 && curB >= 0) {
            if (A[curA] > B[curB]) {
                A[len--] = A[curA--];
            } else {
                A[len--] = B[curB--];
            }
        }

        while(curA >= 0) {
            A[len--] = A[curA--];
        }

        while(curB >= 0) {
            A[len--] = B[curB--];
        }
    }

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 2;
        A[1] = 4;
        A[2] = 6;
        int[] B = {1, 3};

        merge(A, 3, B, 2);

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

}
