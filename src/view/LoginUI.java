package view;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame{
    private JPanel container;

    public LoginUI(){
        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(600,600);

        //Set your user screen at the middle of computer's screen
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;


        this.setLocation(x,y);
        this.setVisible(true);


    }
}
