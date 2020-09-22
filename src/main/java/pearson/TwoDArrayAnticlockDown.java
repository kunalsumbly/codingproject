package pearson;

import java.util.ArrayList;
import java.util.List;

public class TwoDArrayAnticlockDown {

  // function to print the
  // required traversal
  static List counterClockspiralPrint(int maxRows, int maxColumns, int startRow, int startColumn) {
    int dirs[][] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    // movement x - axis is column movement
    int xAxis = startColumn - 1;
    // movement y-axis is row movement
    int yAxis = startRow - 1;
    
    int size = maxRows * maxColumns;
    
    if (size < 0) {
      return null;
    }

    if (xAxis < 0 || xAxis >= maxColumns || yAxis < 0 || yAxis >= maxRows) {
      return null;
    }

    int i = 0;
    List result = new ArrayList();
    result.add(xAxis + (yAxis * maxColumns) + 1);

    while (result.size() < size) {
      for (int k = (i % 2) * 2; k < (i % 2) * 2 + 2; k++) {
        int dx, dy;
        dx = dirs[k][0];
        dy = dirs[k][1];
        for (int p = 0; p < i + 1; p++) {
          xAxis = xAxis + dx;
          yAxis = yAxis + dy;
          if (0 <= xAxis && xAxis < maxColumns && 0 <= yAxis && yAxis < maxRows) {
            result.add(xAxis + yAxis * maxColumns + 1);
          }
        }


      }
      i++;
    }
    return result;
  }

  // Driver Code
  public static void main(String[] args) {
    // Function calling 10
    System.out.println(counterClockspiralPrint(5, 5, 3, 2));
    //System.out.println(counterClockspiralPrint(2,4, 1, 2));
  }

}
