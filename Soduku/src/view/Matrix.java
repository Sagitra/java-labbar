package view;



import java.awt.*;
import javax.swing.*;

public class Matrix {
    private JPanel matrix;
    private static JTextField textrutor[][];
    private static int[][] value;

    public Matrix() {
        matrix = new JPanel(new GridLayout(9, 9, 2, 2));
        // Initialiserar en array av textrutor
        textrutor = new JTextField[9][9];

        for (int i = 0; i < 9; i++) { //Går igenom en 9x9 array och skapar textrutor för alla
            for (int j = 0; j < 9; j++) {
                textrutor[i][j] = new JTextField();
                // Färgläggning av hörnen
                if ((i < 3 || i > 5) && (j < 3 || j > 5)) {
                    textrutor[i][j].setBackground(Color.CYAN);
                    // Färgläggning av mitten
                } else if ((i > 2 && i < 6) && (j > 2 && j < 6)) {
                    textrutor[i][j].setBackground(Color.CYAN);
                }
                matrix.add(textrutor[i][j]);
            }
        }
    }

    public static int[][] getMatrix() { //Inhämtning av värden som användare fyller i
        value = new int[9][9]; 
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String s = textrutor[i][j].getText();
                if (s.equals("")) {//om det är en tom ruta sätt value till 0
                    value[i][j] = 0;
                } else { //Annarts kontrollera värder i rutan
                    //Ifall det innehåller ETT tecken som är mellan 1 och 9 så lägg till värdet
                    if (s.length() == 1 && (s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
                                value[i][j] = Integer.parseInt(textrutor[i][j].getText());
                    }else { //Annars ogiltig input
                        JOptionPane.showMessageDialog(null, "Ogiltig input", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        return value;
    }

    public static void update(int[][] grid){ //lägger till värde i våra textrutor
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                String temp = grid[r][c] + ""; //Konvertering till String
                textrutor[r][c].setText(temp);
            }
        }
    }

    public static void clearAll() { //Sätter alla till en "tom" string
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textrutor[i][j].setText("");
            }
        }
    }

    public JPanel getPanel() {
        return matrix;
    }
}
