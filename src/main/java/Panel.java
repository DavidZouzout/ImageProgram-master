import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Panel extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 500;
    private final int BUTTON_X = WINDOW_WIDTH / 2 - 85;
    private final int BUTTON_WIDTH = 200;
    JLabel filteredPicLabel;

    public Panel() {
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dzouz\\Documents\\chromedriver_win32\\chromedriver.exe");
        String url = ("https://www.facebook.com/public/");
        File output = new File("C:\\Users\\dzouz\\Pictures\\Memes\\firstTry.png");

        JTextField searchBar = new JTextField();
        int BUTTON_HEIGHT = 40;
        searchBar.setBounds(BUTTON_X, 80, 120, BUTTON_HEIGHT);
        this.add(searchBar);
        repaint();

        JButton searchButton = makeButton("Search", searchBar.getX() + searchBar.getWidth(), searchBar.getY(), searchBar.getWidth() - 40, searchBar.getHeight());
        this.add(searchButton);
        repaint();

        JButton colorShiftRight = makeButton("ColorShiftRight", BUTTON_X, searchButton.getY() + searchButton.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        colorShiftRight.setVisible(false);
        this.add(colorShiftRight);
        repaint();

        JButton colorShiftLeft = makeButton("ColorShiftLeft", BUTTON_X, colorShiftRight.getY() + colorShiftRight.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        colorShiftLeft.setVisible(false);
        this.add(colorShiftLeft);
        repaint();

        JButton intenseColor = makeButton("IntenseColor", BUTTON_X, colorShiftLeft.getY() + colorShiftLeft.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        intenseColor.setVisible(false);
        this.add(intenseColor);
        repaint();

        JButton greyScale = makeButton("GreyScale", BUTTON_X, intenseColor.getY() + intenseColor.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        greyScale.setVisible(false);
        this.add(greyScale);
        repaint();

        JButton contracts = makeButton("Contracts", BUTTON_X, greyScale.getY() + greyScale.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        contracts.setVisible(false);
        this.add(contracts);
        repaint();

        JButton flipImage = makeButton("FlipImage", BUTTON_X, contracts.getY() + contracts.getHeight() + 10, BUTTON_WIDTH, BUTTON_HEIGHT);
        flipImage.setVisible(false);
        this.add(flipImage);
        repaint();


        searchButton.addActionListener((event) -> {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(url + searchBar.getText());


            WebElement profile = driver.findElement(By.className("_4bl7"));
            profile.click();

            while (true) {
                if (driver.findElement(By.className("gmql0nx0")).isDisplayed()) break;
            }

            WebElement profilePicture = driver.findElement(By.className("mpmpiqla"));
            profilePicture.click();

            WebElement profilePictureXPath = driver.findElement(By.xpath("//img[@class='ji94ytn4 d2edcug0 r9f5tntg r0294ipz']"));

            String str = profilePictureXPath.getAttribute("src");
            System.out.println(str);
            BufferedImage profilePictureAsAnImage;
            try {
                profilePictureAsAnImage = ImageIO.read(new URL(str));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Image scaledImage = profilePictureAsAnImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
            picLabel.setBounds(65, 80, 300, 300);
            this.add(picLabel);
            repaint();
            Image filteredPic = scaledImage;
            filteredPicLabel = new JLabel(new ImageIcon(filteredPic));
            filteredPicLabel.setBounds(searchButton.getX() + searchButton.getWidth() + 60, 80, 300, 300);
            this.add(filteredPicLabel);
            repaint();
            colorShiftRight.setVisible(true);
            colorShiftLeft.setVisible(true);
            intenseColor.setVisible(true);
            greyScale.setVisible(true);
            contracts.setVisible(true);
            flipImage.setVisible(true);
            driver.manage().window().minimize();

            try {
                ImageIO.write(toBufferedImage(filteredPic), "png", output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Filters filters = new Filters();
        colorShiftRight.addActionListener((secondEvent) -> {
            try {
                File file = filters.colorShiftRight(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        colorShiftLeft.addActionListener((secondEvent) -> {
            try {
                File file = filters.colorShiftLeft(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        intenseColor.addActionListener((secondEvent) -> {
            try {
                File file = filters.intenseColor(output, 1.5);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        greyScale.addActionListener((secondEvent) -> {
            try {
                File file = filters.greyScale(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        contracts.addActionListener((secondEvent) -> {
            try {
                File file = filters.contracts(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        flipImage.addActionListener((secondEvent) -> {
            try {
                File file = filters.flipImage(output);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public JButton makeButton(String str, int x, int y, int width, int height) {
        JButton tempButton = new JButton(str);
        tempButton.setBounds(x, y, width, height);
        this.add(tempButton);
        return tempButton;
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bImage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bImage;
    }

}
