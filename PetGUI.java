package com.david;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by David on 4/2/2017.
 */
public class PetGUI extends JFrame {
    private JPanel rootPanel;
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JLabel surveyResultsLabel;
    private JButton quitButton;

    private boolean dog;
    private boolean cat;
    private boolean fish;

    protected PetGUI(){
        setContentPane(rootPanel);
        pack();
        setSize(new Dimension(350,200));
        setTitle("Pet Survey");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });
        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isBorderPaintedFlat();
                updateResults();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetGUI.this, "Are you sure you want to quit?",
                        "Quit",JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }

            }
        });
    }
    private void updateResults(){
        String hasDog = dog ? "One dog" : "no dogs";
        String hasCat = cat ? "One cat" : "no cats";
        String hasFish = fish ? "One fish" : "no fish";

        String results = "You have " + hasDog + " and " + hasCat  +" and " + hasFish;
        surveyResultsLabel.setText(results);
    }
}
