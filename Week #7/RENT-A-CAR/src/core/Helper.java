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
    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static void showMsg(String str,String title) {
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
            default:
                msg = str;
                header = title;
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


}
