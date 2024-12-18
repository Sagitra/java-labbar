package model;

public class Solver implements SudokuSolver {
    private int[][] matrix;

    public Solver(int[][] input) {
        matrix = new int[9][9];
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                matrix[r][c] = input[r][c];
            }
        }
    }

    public boolean solve() {
        if(isAllValid()){ //kontroll av giltig startpunkt innan lösning
            return solve(0,0);
        }else{
            return false;
        }
            
    }

    private boolean solve(int r, int c) {
        if(r == 9){ //Når vi r == 9 så har vi kommit till sista raden, det är löst
            return true;
        }

        if(c == 9){//Når vi sista kolumnen i raden hoppar vi till nästa rad
            return solve(r + 1, 0);
        }

        if(matrix[r][c] != 0){ //Ifall rutan redan är löst hoppar vi till nästa
            return solve(r, c + 1);
        }

        for(int i = 1; i < 10; i++){
            set(r, c, i); //Sätter värdet på en tom ruta till i
            if(isValid(r, c)){ 
                //Ifall vår insättning var korrekt så hoppar vi till nästa kolumn
                if(solve(r, c + 1)){ //Ifall vi når slutet och alla blir korrekt så kommer allt bli true
                    return true;
                }
            }
            //Hittar vi ingen siffra som passar in och vi inte returnerat så sätter vi rutan till 0
            // och hoppar då tillbaka och börjar om igen.
            set(r,c,0); 
        }

        return false;
    }

    public void set(int row, int col, int d) {
        matrix[row][col] = d;
    }

    public int get(int row, int col) {
        return matrix[row][col];
    }

    public void clear(int row, int col) {
        matrix[row][col] = 0;
    }

    public void clearAll() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public boolean isValid(int row, int col) { //kontroll av en rad/col och 3x3 ruta
        return regionValid(row, col) && rowColValid(row, col);
    }

    private Boolean rowColValid(int r, int c){ //kontroll row/col
        int temp = get(r, c);
        if(temp == 0){ //En tom cell kan ju inte vara olagligt placerad
            return true;
        }

        for(int row = 0; row < 9; row++){ // kontroll av kollum
            if(matrix[row][c] == get(r, c) && r != row){ //Om det är en match som inte är vår indata
                return false;
            }
        }

        for(int col = 0; col < 9; col++){ // kontroll av rad
            if(matrix[r][col] == get(r, c) && c != col){ //Ifall det finns en match som inte är 0
                 return false;    
            }
        }
        return true;
    }

    private Boolean regionValid(int r, int c) { //Kontroll av 3x3
        if(get(r,c) == 0){ //En tom ruta kan ej vara ogiltig
            return true;
        }
        
        int rowS = (r / 3) * 3; // Använder oss av att decimaler bara kapas av vid division
        int colS = (c / 3) * 3; // så 4 / 3 = 1. * 3 = 3, startvärde => 3

        // Går igenom 3x3 regionen som vår input ligger i
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(r == rowS + i && c == colS + j)) { // Kollar inte ifall input är lika med sig själv
                    //Ifall något annat element skulle vara samma som vår input så är det fel
                    if (matrix[rowS + i][colS + j] == get(r, c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isAllValid() { //Kontrollering av alla row/col och alla 3x3
        for(int r = 0;  r < 9; r++){ 
            for(int c = 0; c < 9; c++){
                if(!rowColValid(r, c)){ //Ifall rad/colum är falsk så är allt falskt
                    return false;
                }
            }
        }

        for(int r = 0; r < 9; r+=3){
            for(int c = 0; c < 9; c+=3){ //Är en region falsk så är allt falskt
                if(!regionValid(r, c)){
                    return false;
                }
            }
        }
        return true;
    }

    public void setGrid(int[][] m) { //Inte direkt åtkomst av matrix
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                matrix[r][c] = m[r][c];
            }
        }
    }

    public int[][] getGrid() { //Inre matrisen skall inte kommas åt utanför, därav temp
        int[][] temp = new int[9][9];
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                temp[r][c] = matrix[r][c];
            }
        }
        return temp;
    }
    
    // ONÖDIG METOD
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            //System.out.println("\n");
            sb.append("\n");
            for (int j = 0; j < 9; j++) {
                //System.out.print(matrix[i][j]);
                sb.append(matrix[i][j] + "  ");
            }
        }
        return sb.toString().trim();
    }

}
