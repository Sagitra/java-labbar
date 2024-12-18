package test.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import model.Solver;

class SolverTest {
    String emptySolve = 
    "1  2  3  4  5  6  7  8  9  " + "\n" +  
    "4  5  6  7  8  9  1  2  3  " + "\n" + 
    "7  8  9  1  2  3  4  5  6  " + "\n" +  
    "2  1  4  3  6  5  8  9  7  " + "\n" + 
    "3  6  5  8  9  7  2  1  4  " + "\n" +
    "8  9  7  2  1  4  3  6  5  " + "\n" + 
    "5  3  1  6  4  2  9  7  8  " + "\n" + 
    "6  4  2  9  7  8  5  3  1  " + "\n" + 
    "9  7  8  5  3  1  6  4  2";
    
    @Test
    @DisplayName("Empty soduko")
    public void emptySoduko(){
        Solver s = new Solver(new int[9][9]);
        assertTrue(s.solve());
        assertEquals(emptySolve, s.toString());
    }  

    int[][] given = {{0,0,8,0,0,9,0,6,2}, 
    {0,0,0,0,0,0,0,0,5},
    {1,0,2,5,0,0,0,0,0},
    {0,0,0,2,1,0,0,9,0},
    {0,5,0,0,0,0,6,0,0},
    {6,0,0,0,0,0,0,2,8},
    {4,1,0,6,0,8,0,0,0},
    {8,6,0,0,3,0,1,0,0},
    {0,0,0,0,0,0,4,0,0}};

    String solutionString = 
    "5  4  8  1  7  9  3  6  2  \n" + 
    "3  7  6  8  2  4  9  1  5  \n" + 
    "1  9  2  5  6  3  8  7  4  \n" + 
    "7  8  4  2  1  6  5  9  3  \n" + 
    "2  5  9  3  8  7  6  4  1  \n" + 
    "6  3  1  9  4  5  7  2  8  \n" + 
    "4  1  5  6  9  8  2  3  7  \n" + 
    "8  6  7  4  3  2  1  5  9  \n" + 
    "9  2  3  7  5  1  4  8  6";
    @Test
    @DisplayName("Given soduko")
    public void givenSoduko(){
        Solver s = new Solver(given);
        assertTrue(s.solve());
        assertEquals(solutionString, s.toString());
    }



    @Test
    @DisplayName("Olösliga sodukon")
    public void unsolable(){
        int[][] test1 = new int[9][9];
        test1[0][0] = 5; test1[0][8] = 5; //Samma rad

        int[][] test2 = new int[9][9];
        test2[0][2] = 2; test2 [7][2] = 2; //Samma kolumn

        int[][] test3 = new int[9][9];
        test3[0][0] = 7; test3[2][1] = 7; //Samma region

        Solver s = new Solver(test1);
        assertFalse(s.solve());
        s.setGrid(test2);
        assertFalse(s.solve());
        s.setGrid(test3);
        assertFalse(s.solve());
    }
    
}
