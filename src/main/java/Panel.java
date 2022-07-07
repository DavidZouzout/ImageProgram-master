import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Panel extends JFrame {
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 500;
    Buttons buttons;
    Filters filters = new Filters();
    Bot bot;
    JLabel filteredPicLabel;
    String url;
    File output;
    File file;

    public Panel() {
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
    }

    public void doEveryThing() {
        /* Please put the webDriver location inside "System.setProperty(..." */
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dzouz\\Documents\\chromedriver_win32\\chromedriver.exe");
        url = ("https://www.facebook.com/public/");
        /* Please put the file location where you'd like to store your original image, after the "output = new File(..." */
        output = new File("C:\\Users\\dzouz\\Pictures\\Memes\\original.png");

        buttons = new Buttons();
        buttons.searchButton.addActionListener((event) -> {
            bot = new Bot();
            buttons.colorShiftRight.setVisible(true);
            buttons.colorShiftLeft.setVisible(true);
            buttons.sepia.setVisible(true);
            buttons.greyScale.setVisible(true);
            buttons.contracts.setVisible(true);
            buttons.flipImage.setVisible(true);
            bot.picLabel.setVisible(true);
            Main.panel.filteredPicLabel.setVisible(true);

            bot.driver.manage().window().minimize();
        });
        buttons.colorShiftRight.addActionListener((event) -> {
            try {
                file = filters.colorShiftRight(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.colorShiftLeft.addActionListener((event) -> {
            try {
                file = filters.colorShiftLeft(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.sepia.addActionListener((event) -> {
            try {
                file = filters.sepia(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.greyScale.addActionListener((event) -> {
            try {
                file = filters.greyScale(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.contracts.addActionListener((event) -> {
            try {
                file = filters.contracts(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.flipImage.addActionListener((event) -> {
            try {
                file = filters.flipImage(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        repaint();
    }

}

