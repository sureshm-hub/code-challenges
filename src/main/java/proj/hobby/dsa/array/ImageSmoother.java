package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/image-smoother/description
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] img) {

        int m = img.length;
        int n = img[0].length;

        int[][] smooth = new int[m][n];
        for(int r = 0; r < m; r++)
            for(int c = 0; c < n; c++) {
                int count = 0;
                int sum = 0;
                for(int y = r - 1; y <= r + 1; y++) {
                    for(int x = c - 1; x <= c + 1; x++) {
                        if(x >= 0  && x < n && y >= 0 && y < m) {
                            sum += img[y][x];
                            count++;
                        }
                    }
                }
                smooth[r][c] = sum/count;
            }

        return smooth;
    }
}
