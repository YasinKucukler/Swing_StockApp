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

        else
            return true;
    }
}
