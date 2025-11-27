package TBZ.m319.Java.KN05;

import java.util.ArrayList;

/* OHNE KI Geschrieben */

public class ArrayChessGridTest {

  public static void main(String[] args) {
    int row = 8;
    int col = 8;
    ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

    for (int r = 0; r < row; r++) {
      ArrayList<Integer> pos = new ArrayList<>();
      grid.add(pos);
      

      for (int c = 0; c < col; c++) {
        int color = 0;
        if ((r + c) % 2 == 0) {
          color = 1;
          }
        else {
          color = 0;
        }

        pos.add(color);
      }
    }
    for (ArrayList r : grid)
      System.out.println(r);
  }
  
}
