package view;

import core.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame{
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_;
    private JPanel pnl_bottom;
    private JTextField fld_mail;
    private JButton btn_login;
    private JLabel lbl_mail;
    private JLabel lbl_password;
    private JPasswordField fld_password;

    public LoginUI(){
        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(600,600);

        //Set your user screen at the middle of computer's screen
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;


        this.setLocation(x,y);
        this.setVisible(true);


        //"Giriş" button action
        this.btn_login.addActionListener(e -> {
            //System.out.println("Button hit");
            //if(this.fld_mail.getText().isEmpty())
            //if(Helper.isFieldEmpty(this.fld_mail) || Helper.isFieldEmpty(this.fld_password))
            JTextField[] checkList = {this.fld_mail, this.fld_password};
            if (!Helper.isMailValid(this.fld_mail.getText())){
                System.out.println(" Lütfen geçerli bir mail adresi giriniz !!!");
            }
//            if(Helper.isFieldListEmpty(checkList)){
//                System.out.println("Lütfen tüm alanları doldurunuz!!");
//            } else{
//                System.out.println("Giriş yapılıyor....");
//            }
        });
    }
}
