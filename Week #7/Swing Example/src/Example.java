import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame {
    private JPanel container;
    private JLabel label_example;
    private JButton button_example;

    public Example() {
        this.add(container);
        this.setSize(300,300);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth())   / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;

        this.setLocation(x,y);



        this.setVisible(true);
        button_example.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label_example.setText("PRESSED");

            }
        });
    }
}
