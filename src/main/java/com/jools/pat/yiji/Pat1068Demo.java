package main.java.com.jools.pat.yiji;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/3/26 15:51
 * @description: TODO
 */
public class Pat1068Demo {

    // 统计颜色值
    private static List<Long> colors = new ArrayList<>();

    // 统计颜色值的坐标
    private static List<int[]> locations = new ArrayList<>();

    private static Map<Long, Integer> cnt = new HashMap<>();

    // 颜色差阙值
    static long TOL;

    public static void main(String[] args) {

        Integer.toString(111, 2);

        Scanner s = new Scanner(System.in);
        String[] line1 = s.nextLine().split("\\s+");
        int M = Integer.valueOf(line1[0]);
        int N = Integer.valueOf(line1[1]);
        TOL = Long.valueOf(line1[2]);
        // System.out.println("M=" + M + " N=" + N + " TOL=" + TOL);

        long[][] matrix = new long[N][M];
        for (int i = 0; i < N; i++) {
            String input = s.nextLine().replaceAll("\t", "");
            String[] inputs = input.split("\\s+");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Long.valueOf(inputs[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (needRecord(matrix, i, j)) {
                    colors.add(matrix[i][j]);
                    locations.add(new int[]{i, j});
                }
            }
        }

        int size = colors.size();

        for (long l : cnt.keySet()) {
            if (cnt.get(l) > 1) {
                size -= cnt.get(l);
            }
        }

        if (size > 1) {
            System.out.println("Not Unique");
        } else if (size < 1) {
            System.out.println("Not Exist");
        } else {
            for (long l : cnt.keySet()) {
                if (cnt.get(l) > 1) {
                    continue;
                }
                int[] loca = locations.get(colors.indexOf(l));
                 System.out.println(String.format("(%d, %d): %d", loca[1] + 1, loca[0] + 1, l));
            }
        }
    }

    // 检查坐标是否在矩阵范围内
    private static boolean isInBounds(long[][] matrix, int rowIndex, int colIndex) {
        int row = matrix.length;
        int col = matrix[0].length;
        return rowIndex >= 0 && rowIndex < row && colIndex >= 0 && colIndex < col;
    }

    // 与每个相邻的节点颜色差值都需要大于 TOL 才可以被记录
    private static boolean needRecord(long[][] matrix, int rowIndex, int colIndex) {
        long curr = matrix[rowIndex][colIndex];
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = rowIndex + dx[i];
            int newCol = colIndex + dy[i];
            if (isInBounds(matrix, newRow, newCol) && Math.abs(curr - matrix[newRow][newCol]) <= TOL) {
                return false;
            }
        }
        cnt.put(curr, cnt.getOrDefault(curr, 0) + 1);    // 标记此颜色值出现一次
        return true;
    }

}
