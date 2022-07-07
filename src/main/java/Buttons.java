import javax.swing.*;

public class Buttons extends JFrame {
    private final int BUTTON_X = Panel.WINDOW_WIDTH / 2 - 85;
    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 40;

    JTextField searchBar;
    JButton searchButton;
    JButton colorShiftRight;
    JButton colorShiftLeft;
    JButton intenseColor;
    JButton greyScale;
    JButton contracts;
    JButton flipImage;

    public Buttons() {
        searchBar = new JTextField();
        searchBar.setBounds(BUTTON_X, 80, 120, BUTTON_HEIGHT);
        Main.panel.add(searchBar);
        searchBar.setVisible(true);

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

        intenseColor = makeButton("IntenseColor", BUTTON_X, colorShiftLeft.getY() + colorShiftLeft.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        intenseColor.setVisible(false);
        Main.panel.add(intenseColor);
        repaint();

        greyScale = makeButton("GreyScale", BUTTON_X, intenseColor.getY() + intenseColor.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
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
    }

    public JButton makeButton(String str, int x, int y, int width, int height) {
        JButton tempButton = new JButton(str);
        tempButton.setBounds(x, y, width, height);
        Main.panel.add(tempButton);
        return tempButton;
    }
}
