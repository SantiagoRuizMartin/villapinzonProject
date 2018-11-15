import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainView {
    private JPanel mainPanel;
    private JLabel mapImage;
    private JLabel locationImage;
    private JTextArea mapInfoText;
    private JPanel secondaryPanel;
    private JButton editInformationButton1;
    private JButton showImagesButton;
    private JLabel titleLabel;
    private JPanel jpanelMap;
    private JPanel imagesPanel;
    private JLabel imagesLabel;
    private JButton nextImageButton;
    private JButton previewImageButton;
    private JMenuBar menuBar;
    private JMenu menu, submenu;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem cbMenuItem;
    ArrayList<String> sonsaNames;
    ArrayList<String> chasquesNames;
    ArrayList<String> chigualaNames;
    ArrayList<String> salitreNames;
    private int c = 0;

    private double x, y;

    public MainView() {
        setChasquesNames();
        setChigualaNames();
        setSalitreNames();
        setSonsaNames();
        editInformationButton1.setEnabled(false);
        JFrame frame = new JFrame("Proyecto Villapinzón");
        frame.setContentPane(mainPanel);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1300, 700);
        frame.setMinimumSize(new Dimension(1000, 650));
        frame.setVisible(true);

        mapImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();

                System.out.println("Position x: " + x + " , Position y: " + y);
                if (x >= 227.0 && x <= 237.0 && y >= 288.0 && y <= 298.0) {//Chasques
                    mapInfoText.setText("COPLAS\n\n" +
                            "1. El gallo en el gallinero\n" +
                            "Se sacude y se menea\n" +
                            "Así le pasa a usted\n" +
                            "Me mira y se saborea.\n\n" +
                            "Carlos Cárdenas C.\n" +
                            "68 años. Chazques");
                    imagesLabel.setIcon(new ImageIcon(chasquesNames.get(0)));
                    imagesLabel.setVisible(true);
                } else if (x >= 101.0 && x <= 107.0 && y >= 327.0 && y <= 335.0) {//Chiguala
                    mapInfoText.setText("COPLAS\n\n" +
                            "1. Las mujeres también sienten\n" +
                            "Cuando uno se va y las deja\n" +
                            "Porque son de carne u hueso\n" +
                            "Como cualquier yegua vieja.\n\n" +
                            "Alcides Pinzón\n" +
                            "62 años. Chiguala\n\n" +
                            "2. En la puerta de mi casa\n" +
                            "Tengo una mata de te\n" +
                            "Las hojas me están diciendo\n" +
                            "Que me case con usted.\n\n" +
                            "Héctor Riaño R.\n" +
                            "72 años. Chiguala\n\n" +
                            "3. Allá arriba en aquel alto\n" +
                            "Tengo una cabra amarrada\n" +
                            "En los ojos y en la cara\n" +
                            "Se parece a mi cuñada.\n\n" +
                            "María Adelina Díaz\n" +
                            "60 años. Chiguala\n\n" +
                            "4. Por los campos de Nariño\n" +
                            "Admiramos muchas cosas\n" +
                            "Que evocamos con cariño\n" +
                            "Con sus canciones preciosas.\n\n" +
                            "Abdon Rodríguez\n" +
                            "74 años. Chiguala");
                    imagesLabel.setIcon(new ImageIcon(chigualaNames.get(0)));
                    imagesLabel.setVisible(true);
                } else if (x >= 120.0 && x <= 127.0 && y >= 243.0 && y <= 253.0) {//Salitre
                    mapInfoText.setText("COPLAS\n\n" +
                            "1. Un diablo se cayó al agua\n" +
                            "Porque un diablo lo empujo\n" +
                            "Y otro diablo le dijo\n" +
                            "Como diablos se cayó.\n\n" +
                            "Gilma Inés Pinzón\n" +
                            "61 años. Salitre");
                    imagesLabel.setIcon(new ImageIcon(salitreNames.get(0)));
                    imagesLabel.setVisible(true);
                } else if (x >= 108.0 && x <= 116.0 && y >= 293.0 && y <= 303.0) {//Sonsa
                    mapInfoText.setText("COPLAS\n\n" +
                            "1. Por esta cañada abajo\n" +
                            "Con mi yunta de bueyes toscos\n" +
                            "Cierra la jeta pendejo\n" +
                            "Que se te llena de moscos.\n\n" +
                            "José Buenaventura G.\n" +
                            "81 años. Sonsa");
                    imagesLabel.setIcon(new ImageIcon(sonsaNames.get(0)));
                    imagesLabel.setVisible(true);
                }
            }
        });
        editInformationButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapInfoText.setEditable(true);
            }
        });
        nextImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int limit = imagesNames.size();
//                if (c < limit) {
//                    imagesLabel.setIcon(new ImageIcon(imagesNames.get(c)));
//                    imagesLabel.repaint();
//                    c++;
//                } else {
//                    c = 0;
//                    imagesLabel.setIcon(new ImageIcon(imagesNames.get(c)));
//                    imagesLabel.repaint();
//                    c++;
//                }
            }
        });
        previewImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        MainView v = new MainView();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        mapImage = new JLabel(new ImageIcon("images/mainMap2.jpg"));
        imagesLabel = new JLabel();
        imagesLabel.setVisible(false);
    }

    private void setSonsaNames() {
        sonsaNames = new ArrayList<>();
        sonsaNames.add("images/sonsa.jpg");
    }

    private void setChasquesNames() {
        chasquesNames = new ArrayList<>();
        chasquesNames.add("images/paramo_guacheneque.jpg");
        chasquesNames.add("images/pozo_de_la_nutria.jpg");
        chasquesNames.add("images/mapV.jpg");
    }

    private void setChigualaNames() {
        chigualaNames = new ArrayList<>();
        chigualaNames.add("images/nacimiento.jpg");
        chigualaNames.add("images/paisaje2.jpg");
    }

    private void setSalitreNames() {
        salitreNames = new ArrayList<>();
        salitreNames.add("images/paisaje.jpg");
    }
}
