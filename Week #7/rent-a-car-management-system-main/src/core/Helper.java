package core;

import javax.swing.*;
import java.awt.*;

public class Helper {

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

    public static void showMessage(String str) {
        String msg;

        String title = switch (str) {
            case "fill" -> {
                msg = "Please fill all the fields!";
                yield "Error";
            }
            case "done" -> {
                msg = "Successful!";
                yield "Success";
            }
            case "notFound" -> {
                msg = "Record not found!";
                yield "Not Found";
            }
            case "error" -> {
                msg = "Something went wrong!";
                yield "Error";
            }
            default -> {
                msg = str;
                yield "Warning";
            }
        };

        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm (String str) {
        String msg;
        if (str.equals("sure")) {
            msg = "Are you sure?";
        } else {
            msg = str;
        }

        return JOptionPane.showConfirmDialog(null, msg, "Are you sure?", JOptionPane.YES_NO_OPTION) == 0;
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field))
                return true;
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.width) / 2;
            default -> 0;
        };
    }
}
