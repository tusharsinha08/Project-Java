import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Multiplication extends JFrame {

    private Container c;
    private Font f;
    private Cursor cursor;
    private ImageIcon image;
    private JLabel imgLabel;
    private JLabel textLabel;
    private JTextField numTF;
    private JButton enterBtn;
    private JButton clearBtn;
    private JTextArea textTA;

    Multiplication() {
        initComponent();

        setVisible(true);
        setTitle("Multiplication Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(300, 50, 455, 700);
    }

    public void initComponent() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);

        f = new Font("Tahoma", Font.BOLD, 22);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        image = new ImageIcon(getClass().getResource("multiplication_image.jpg"));

        imgLabel = new JLabel(image);
        imgLabel.setBounds(5, 5, image.getIconWidth(), image.getIconHeight());
        c.add(imgLabel);

        textLabel = new JLabel("Enter any number :");
        textLabel.setFont(f);
        textLabel.setForeground(Color.WHITE);
        textLabel.setBounds(5, 170, 250, 50);
        c.add(textLabel);

        numTF = new JTextField();
        numTF.setFont(f);
        numTF.setBackground(Color.WHITE);
        numTF.setHorizontalAlignment(JTextField.CENTER);
        numTF.setBounds(310, 170, 100, 50);
        c.add(numTF);

        enterBtn = new JButton("Enter");
        enterBtn.setBackground(Color.LIGHT_GRAY);
        enterBtn.setFont(f);
        enterBtn.setCursor(cursor);
        enterBtn.setBounds(310, 230, 100, 50);
        c.add(enterBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBackground(Color.LIGHT_GRAY);
        clearBtn.setFont(f);
        clearBtn.setCursor(cursor);
        clearBtn.setBounds(200, 230, 100, 50);
        c.add(clearBtn);

        textTA = new JTextArea();
        textTA.setBackground(Color.WHITE);
        textTA.setFont(f);
        textTA.setBounds(5, 290, 430, 370);
        c.add(textTA);

        numTF.addActionListener(new EnterBtnListener());
        enterBtn.addActionListener(new EnterBtnListener());

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numTF.setText("");
                textTA.setText("");
            }
        });
    }

    public class EnterBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            textTA.setText("");

            String input = numTF.getText();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You entered nothing");
            } else {
                int num = Integer.parseInt(numTF.getText());

                for (int i = 1; i <= 10; i++) {

                    int result = i * num;

                    String r = String.valueOf(result);
                    String n = String.valueOf(num);
                    String mult = String.valueOf(i);

                    textTA.append("  " + n + " x " + mult + " = " + r + "\n");
                }
            }

        }
    }

    public static void main(String[] args) {
        new Multiplication();
    }
}
