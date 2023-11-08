package linea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Linea {

    private char gameMode;
    private int maxHight;
    List<ArrayList<Integer>> table;

    public Linea(int prompt, int prompt1, char c) {
        this.table = new ArrayList<>();
        for(int i = prompt ; i > 0;i--){
            table.add(new ArrayList<Integer>());
        }
        this.maxHight = prompt1;
        this.gameMode = c;
    }

    public boolean show() {
    }

    public boolean finished() {
        if(this.gameMode == 'A') {
            for(int index = 0; index == table.size()-1; index++  ) {
                ArrayList<Integer> column = this.table.get(index);
                if (column.get(column.size()-1) == 1){

                }

            }
        }
    }

    public void playRedAt(int prompt) {
    }

    public void playBlueAt(int prompt) {
    }

    public char getGameMode() {
        return gameMode;
    }

    public int getMaxHight() {
        return maxHight;
    }
}
