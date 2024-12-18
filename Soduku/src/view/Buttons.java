package view;


import java.awt.Dimension;

import javax.swing.*;

import model.Solver;

public class Buttons {
    private ButtonGroup btnGrp;
    private JButton solve;
    private JButton clear;
    Solver s;

    public Buttons() {
        s = new Solver(Matrix.getMatrix());

        // Skapandet av knapparna
        solve = new JButton("Solve");
        clear = new JButton("Clear");

        btnGrp = new ButtonGroup();
        btnGrp.add(solve);
        btnGrp.add(clear);

        solve.addActionListener(e -> {
            s.setGrid(Matrix.getMatrix());//Hämtar de som användare har fyllt i
            if (!s.isAllValid()) { //Om det är en oglitig start meddelas detta
                JOptionPane.showMessageDialog(null, "Ogiltigt startläge", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                        return;
            }else{   
                if(s.solve()){
                    Matrix.update(s.getGrid()); //Uppdaterar textrutorna
                }else{
                    JOptionPane.showMessageDialog(null, "Olösligt", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });

        clear.addActionListener(e -> {
            Matrix.clearAll(); //Rensar alla rutorna
        });
    }

    public JPanel getPanel() {
        JPanel buttons = new JPanel();

        // Val av knapplayout
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        //Kosmetiska saker för knapparna
        buttons.add(Box.createHorizontalGlue());
        buttons.add(solve);
        buttons.add(Box.createRigidArea(new Dimension(20, 0)));
        buttons.add(clear);
        buttons.add(Box.createHorizontalGlue());

        return buttons;
    }

}
