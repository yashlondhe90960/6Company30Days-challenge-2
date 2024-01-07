class Solution 
{
    // private final int[][] directions = {
    //     {-1, -1}, {-1, 0}, {-1, 1},
    //     {0, -1}, {0, 0}, {0, 1},
    //     {1, -1}, {1, 0}, {1, 1}
    // };

   //approach02: using constant space
   //T.C: O(n*m)
   //S.C: O(1)
    public int[][] imageSmoother(int[][] img) {
     // Save the dimensions of the image.
        int m = img.length;
        int n = img[0].length;

        // Create temp array of size n.
        int[] temp = new int[n];
        int prevCorner = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0;
                int count = 0;

                // Bottom neighbors
                if (i + 1 < m) {
                    if (j - 1 >= 0) {
                        sum += img[i + 1][j - 1];
                        count += 1;
                    }
                    sum += img[i + 1][j];
                    count += 1;
                    if (j + 1 < n) {
                        sum += img[i + 1][j + 1];
                        count += 1;
                    }
                }

                // Next neighbor
                if (j + 1 < n) {
                    sum += img[i][j + 1];
                    count += 1;
                }

                // This cell
                sum += img[i][j];
                count += 1;

                // Previous neighbor
                if (j - 1 >= 0) {
                    sum += temp[j - 1];
                    count += 1;
                }

                // Top neighbors
                if (i - 1 >= 0) {
                    // Left-top corner-sharing neighbor.
                    if (j - 1 >= 0) {
                        sum += prevCorner;
                        count += 1;
                    }

                    // Top edge-sharing neighbor.
                    sum += temp[j];
                    count += 1;

                    // Right-top corner-sharing neighbor.
                    if (j + 1 < n) {
                        sum += temp[j + 1];
                        count += 1;
                    }
                }

                // store corner value
                if (i - 1 >= 0) {
                    prevCorner = temp[j];
                }

                // Store current value
                temp[j] = img[i][j];

                // Overwrite with smoothed value.
                img[i][j] = sum / count;
            }
        }

        // Return the smooth image.
        return img;
    }
}





 //approsch 1 using simple for loops
    //tc: O(m*n)
    //sc: O(m*n)
   // int m = img.length;
        // int n = img[0].length;

        // int[][] result = new int[m][n];

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         int sum = 0;
        //         int count = 0;

        //         // Iterate over all plausible nine indices.
        //         for (int[] direction : directions) {
        //             // If the indices form a valid neighbor
        //             int i_ = i + direction[0];
        //             int j_ = j + direction[1];

        //             if (0 <= i_ && i_ < m && 0 <= j_ && j_ < n) {
        //                 sum += img[i_][j_];
        //                 count += 1;
        //             }
        //         }

        //         result[i][j] = sum / count;
        //     }
        // }

        // return result;








        // int rows = img.length;
        // int cols = img[0].length;
        // int[][] result = new int[rows][cols];

        // for (int i = 0; i < rows; ++i) {
        //     for (int j = 0; j < cols; ++j) {
        //         int totalSum = 0;
        //         int count = 0;

        //         for (int x = Math.max(0, i-1); x < Math.min(rows, i+2); ++x) {
        //             for (int y = Math.max(0, j-1); y < Math.min(cols, j+2); ++y) {
        //                 totalSum += img[x][y];
        //                 count += 1;
        //             }
        //         }

        //         result[i][j] = totalSum / count;
        //     }
        // }

        // return result;