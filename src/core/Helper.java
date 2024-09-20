package core;

import javax.swing.*;

public class Helper {

    // setting backplan colour
    public static void setTheme(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if ( info.getName().equals("Nimbus")){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    /// input alanlarının doluluğu kontrolü -- yardımcı fonksiyon
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty(); //trim sağdan ve soldan boşlukları kaldırır. Burada boşluk varsa onları kabul etmemek için eklenmiştir.
    }

    /// input alanlarının doluluğu kontrolü
    public static boolean isFieldListEmpty(JTextField[] fields){ // Array içindeki field dolu mu boş mu?
        for(JTextField field : fields){
            if(isFieldEmpty(field))
                return true;
        }
        return false;
    }
    /// mail geçerliliği kontrolü
    public static boolean isMailValid(String mail){
        // info@yasin.dev
        // @ olmalı , @ ten önce bir değer olmalı, @ ten sonra nokta ve değer olmalı .domainname gibi
        // noktadan önce ve sonra değer olmalı
        if (mail == null || mail.trim().isEmpty())
            return false;

        if (!mail.contains("@"))
            return false;

        String[] parts = mail.split("@"); // @  in olduğu yerden maili böler
        if (parts.length != 2)
            return false;

        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty())
            return false;

        if (!parts[1].contains("."))
            return false;
        if(!checkSidesOfDot(parts[1])){
            return false;
        }

        else
            return true;
    }

    ///mailde nokta öncesi ve sonrası için kontroller
    public static boolean checkSidesOfDot(String afterAt){
        String[] parts = afterAt.split("\\."); // .  nın olduğu yerden maili böler
        if (parts.length != 2)
            return false;
        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty())
            return false;
        if (parts[1].length() < 2) {
            return false;
        }
        else
            return true;
    }

    ///Hata uyarısı için açılır pencere
    ///Dinamik bir pencere olması tercih edilir
    ///singleton pattern ı da sağlar böylece
    public static void showMgs(String message){
        String msg;
        String title = switch (message) {
            case "fill" -> {
                msg = "Lütfen tüm alanları doldurunuz!";
                yield "ERROR";
            }
            case "done" -> {
                msg = "İşlem başarılı";
                yield "Congrats";
            }
            case "error" -> {
                msg = "An Error Occured";
                yield "ERROR";
            }
            default -> {
                msg = message;
                yield "Information";
            }
        };
        JOptionPane.showMessageDialog(null, msg,title, JOptionPane.INFORMATION_MESSAGE);
    }
}
