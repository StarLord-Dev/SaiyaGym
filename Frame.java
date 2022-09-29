package Visualizer;

import javax.swing.*;
import java.awt.*;;

public class Frame extends JFrame{

    public Frame(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        size.height = size.height - 80;
        size.width = size.width - 80;

        setMinimumSize(size);
        setTitle("Team Wilson Hentz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
            
            add(new PrincipalPanel());
    }
    
}
