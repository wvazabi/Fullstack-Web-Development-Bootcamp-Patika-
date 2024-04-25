package core;

import javax.swing.*;
import java.awt.*;

public class Helper {
    //TODO change theme
    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            }
        }
    }

    //TODO check  empty field
    public static boolean isFieldListEmpty(JTextField[] fieldList){
        for (JTextField field :fieldList){
            if(isFieldEmpty(field)) return true;
        }
        return false;
    }
    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

   //JOptionPane sınıfından türetilmiş show message dialog metodu
    public static void showMsg(String str, String title) {
        String msg;
        String header = title;
        switch (str) {
            case "fill":
                msg = "Please fill empty fields";
                header = "Alert !";
                break;
            case "done":
                msg = "Successfully completed";
                header = "Completed";
                break;
            case "error":
                msg = "Error";
                header = "Error Message";
            default:
                msg = str;
                header = title;
        }


        JOptionPane.showMessageDialog(null,
                msg,
                header,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showMsg(String str) {
        String msg;
        String header;
        switch (str) {
            case "fill":
                msg = "Please fill empty fields";
                header = "Alert !";
                break;
            case "done":
                msg = "Successfully completed";
                header = "Completed";
                break;
            case "error":
                msg = "Error";
                header = "Error Message";
            default:
                msg = str;
                header = "Message";
        }

        JOptionPane.showMessageDialog(null,
                msg,
                header,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static int setLoc(String type, Dimension size) {

        switch (type) {
            case "x":
                return (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y":
                return (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default:
                return 0;
        }
    }

    public static boolean confirm(String str) {
        String msg;
        if (str.equals("sure")) {
            msg = "Are you sure !!";

        } else {
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null, msg, "Are you sure?", JOptionPane.YES_NO_OPTION) == 0;

    }


}
