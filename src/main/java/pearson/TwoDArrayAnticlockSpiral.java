package pearson;

import java.util.ArrayList;
import java.util.List;

public class TwoDArrayAnticlockSpiral {
  int dirs[][] = {
      {0, -1}, // up 
      {-1, 0}, // left
      {0, 1}, // down
      {1, 0} // right
  };

  // function to print the
  // required traversal
  public  List<Integer> counterClockSpiral(int maxRows, int maxColumns, int startRow, int startColumn) {
    
    
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

}
