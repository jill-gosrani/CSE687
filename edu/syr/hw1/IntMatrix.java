package edu.syr.hw1;

public class IntMatrix {
    private int[] data;
    private int rows;
    private int columns;
    public IntMatrix(int r, int c) {
        if(r >= 1 && c >= 1){
            this.rows = r;
            this.columns = c;
            this.data = new int[r * c];
        } else{
            throw new UnsupportedOperationException("The Matrix should have a positive number");
        }
    }
    public int get(int r, int c) {
        if(r >= 0 && c >= 0 && r < this.rows && c < this.columns) {
            return this.data[r * this.columns + c];
        } else {
            throw new UnsupportedOperationException("Not a valid cell");
        }
    }

    public void set(int r, int c, int val) {
        if(r >= 0 && c >= 0 && r < this.rows && c < this.columns) {
            this.data[r * this.columns + c] = val;
        } else {
            throw new UnsupportedOperationException("Not a valid cell");
        }
    }

    public void initialize(int val) {
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                this.data[i * this.columns + j] = val;
            }
        }
        // throw new UnsupportedOperationException("");
    }
}
