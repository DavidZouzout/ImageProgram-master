import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class Bot extends JFrame {
    String url = ("https://www.facebook.com/public/");
    JLabel picLabel;
    BufferedImage profilePictureAsAnImage;
    ChromeDriver driver;

    public Bot() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url + Main.panel.buttons.searchBar.getText());

        WebElement profile = driver.findElement(By.className("_4bl7"));
        profile.click();

        while (true) if (driver.findElement(By.className("gmql0nx0")).isDisplayed()) break;

        WebElement profilePicture = driver.findElement(By.className("mpmpiqla"));
        profilePicture.click();
        while (true) if (driver.findElement(By.className("mpmpiqla")).isDisplayed()) break;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement profilePictureXPath = driver.findElement(By.xpath("//img[@class='ji94ytn4 d2edcug0 r9f5tntg r0294ipz']"));

        String str = profilePictureXPath.getAttribute("src");

        try {
            profilePictureAsAnImage = ImageIO.read(new URL(str));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        Image scaledImage = profilePictureAsAnImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        picLabel = new JLabel(new ImageIcon(scaledImage));
        picLabel.setBounds(65, 80, 300, 300);
        picLabel.setVisible(false);
        Main.panel.add(picLabel);
        repaint();

        Main.panel.filteredPicLabel = new JLabel(new ImageIcon(scaledImage));
        Main.panel.filteredPicLabel.setBounds(Main.panel.buttons.searchButton.getX() + Main.panel.buttons.searchButton.getWidth() + 60, 80, 300, 300);
        Main.panel.filteredPicLabel.setVisible(false);
        Main.panel.add(Main.panel.filteredPicLabel);
        repaint();

        try {
            ImageIO.write(toBufferedImage(scaledImage), "png", Main.panel.output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

