import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView {
    private JPanel panel1;
    private JLabel mapImage;
    private JButton button1;
    private JButton acceptButton;
    private double x, y;

    public MainView() {

        mapImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
                System.out.println("Position x: " + x + " , Position y: " + y);
                if (x >= 327.0 && x <= 372.0 && y >= 451.0 && y <= 473.0) {
                    JOptionPane.showMessageDialog(null, "We are in Soatama");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Villapinzon Project");
        frame.setContentPane(new MainView().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 800);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        mapImage = new JLabel(new ImageIcon("im1.png"));
    }
}
