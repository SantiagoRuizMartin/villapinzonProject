import sun.font.TrueTypeFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    ArrayList<String> imagesNames;
    private int c = 0;

    private double x, y;

    public MainView() {
        createMenuBar();
        setNames();
        editInformationButton1.setEnabled(false);
//        editInformationButton1.setSelectedIcon(new ImageIcon("images/infoIco.png"));
        JFrame frame = new JFrame("Villapinzon Project");
        frame.setContentPane(mainPanel);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1500, 800);
        frame.setMinimumSize(new Dimension(1000, 800));
        frame.setVisible(true);

        mapImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();

                System.out.println("Position x: " + x + " , Position y: " + y);
                if (x >= 327.0 && x <= 372.0 && y >= 451.0 && y <= 473.0) {
                    mapInfoText.setText("This is one of the most beautiful places in Villapinzon, there are more than 700" +
                            "people living in this wonderful place");
                    editInformationButton1.setEnabled(true);
                }
            }
        });
        editInformationButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapInfoText.setEditable(true);
            }
        });
        showImagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagesLabel.setVisible(true);
            }
        });
        nextImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int limit = imagesNames.size();
                if (c < limit) {
                    imagesLabel.setIcon(new ImageIcon(imagesNames.get(c)));
                    imagesLabel.repaint();
                    c++;
                } else {
                    c = 0;
                    imagesLabel.setIcon(new ImageIcon(imagesNames.get(c)));
                    imagesLabel.repaint();
                    c++;
                }


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
        mapImage = new JLabel(new ImageIcon("im1.png"));
        locationImage = new JLabel(new ImageIcon("location.png"));
        imagesLabel = new JLabel(new ImageIcon("nature3.jpg"));
        imagesLabel.setVisible(false);
    }

    private void setNames() {
        imagesNames = new ArrayList<>();
        imagesNames.add("nature1.jpg");
        imagesNames.add("nature2.jpg");
        imagesNames.add("nature3.jpg");
        imagesNames.add("nature4.jpg");
        imagesNames.add("nature5.jpg");
    }


    private void createMenuBar() {
        //Create the menu bar.
        menuBar = new JMenuBar();

//Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

//a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, InputEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Both text and icon",
                new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

//a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

//a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

//a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, InputEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

//Build second menu in the menu bar.
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);
    }
}
