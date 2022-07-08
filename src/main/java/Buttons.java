import javax.swing.*;
import java.awt.*;

public class Buttons extends JFrame {
    private final int BUTTON_X = Panel.WINDOW_WIDTH / 2 - 85;
    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 40;

    JLabel title;
    JTextField searchBar;
    JButton searchButton;
    JButton colorShiftRight;
    JButton colorShiftLeft;
    JButton sepia;
    JButton greyScale;
    JButton contracts;
    JButton flipImage;
    JButton original;

    public Buttons() {
        title = new JLabel(" 👇 Facebook Search button 👇 ");
        title.setFont(new Font("Ariel", Font.BOLD, 20));
        title.setBounds(BUTTON_X - 50, 15, 300, BUTTON_HEIGHT);
        Main.panel.add(title);

        searchBar = new JTextField();
        searchBar.setBounds(BUTTON_X, title.getY() + title.getHeight() + 10, 120, BUTTON_HEIGHT);
        Main.panel.add(searchBar);

        searchButton = makeButton("Search", searchBar.getX() + searchBar.getWidth(), searchBar.getY(), searchBar.getWidth() - 40, searchBar.getHeight());
        Main.panel.add(searchButton);
        repaint();

        colorShiftRight = makeButton("ColorShiftRight", BUTTON_X, searchButton.getY() + searchButton.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        colorShiftRight.setVisible(false);
        Main.panel.add(colorShiftRight);
        repaint();

        colorShiftLeft = makeButton("ColorShiftLeft", BUTTON_X, colorShiftRight.getY() + colorShiftRight.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        colorShiftLeft.setVisible(false);
        Main.panel.add(colorShiftLeft);
        repaint();

        sepia = makeButton("sepia", BUTTON_X, colorShiftLeft.getY() + colorShiftLeft.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        sepia.setVisible(false);
        Main.panel.add(sepia);
        repaint();

        greyScale = makeButton("GreyScale", BUTTON_X, sepia.getY() + sepia.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        greyScale.setVisible(false);
        Main.panel.add(greyScale);
        repaint();

        contracts = makeButton("Contracts", BUTTON_X, greyScale.getY() + greyScale.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        contracts.setVisible(false);
        Main.panel.add(contracts);
        repaint();

        flipImage = makeButton("FlipImage", BUTTON_X, contracts.getY() + contracts.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        flipImage.setVisible(false);
        Main.panel.add(flipImage);
        repaint();
        original = makeButton("Original", BUTTON_X, flipImage.getY() + flipImage.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        original.setVisible(false);
        Main.panel.add(original);
        repaint();
    }

    public JButton makeButton(String str, int x, int y, int width, int height) {
        JButton tempButton = new JButton(str);
        tempButton.setBounds(x, y, width, height);
        Main.panel.add(tempButton);
        return tempButton;
    }
}
