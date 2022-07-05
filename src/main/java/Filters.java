import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Filters extends JPanel {
    int i = 1;
    public File colorShiftRight(File file) throws Exception {
        if (file.exists()) {
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    Color color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(green, blue, red);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File output = new File("C:\\Users\\dzouz\\Pictures\\Memes\\COLORSHIFTRIGHT_" + i + "_.png");
            ImageIO.write(image, "png", output);
            i++;
            return output;
        }
        return null;// סוגר שבודק האם הקובץ קיים
    }// end of the changeColor function

    public File colorShiftLeft(File file) throws Exception {
        if (file.exists()) {
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    Color color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(blue, red, green);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File output = new File("C:\\Users\\dzouz\\Pictures\\Memes\\colorShirfLeft_" + i + "_.png");
            ImageIO.write(image, "png", output);
            i++;
            return output;
        }// סוגר שבודק האם הקובץ קיים
        return null;
    }// end of the changeColor function

    public File intenseColor(File file, double by) throws Exception {
        if (file.exists()) {
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                       Color color = new Color(pixel);
                       int red = color.getRed();
                       int green = color.getGreen();
                       int blue = color.getBlue();

                       double increaseRed = red * by;
                       if (increaseRed > 255) increaseRed = 255;

                       double increaseGreen = green * by;
                       if (increaseGreen > 255) increaseGreen = 255;

                       double increaseBlue = blue * by;
                       if (increaseBlue > 255) increaseBlue = 255;

                       Color newColor = new Color((int) increaseRed, (int) increaseGreen, (int) increaseBlue);
                       image.setRGB(x, y, newColor.getRGB());
                    }
                }
                File output = new File("C:\\Users\\dzouz\\Pictures\\Memes\\intenseColor\"+i+\"_.png");
                ImageIO.write(image, "png", output);
                i++;
                return output;
            }
        return null;
    }

    public File greyScale(File file) throws Exception {
        if (file.exists()) {
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    Color color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    int average = (red + green + blue) / 3;
                    Color newColor = new Color(average, average, average);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File output = new File("C:\\Users\\dzouz\\Pictures\\Memes\\greyScale" + i + "_.png");
            ImageIO.write(image, "png", output);
            i++;
            return output;

        }
        return null;
    }

    public File contracts(File file) throws Exception {
        if (file.exists()) {
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    Color color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(255 - red, 255 - green, 255 - blue);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File output = new File("C:\\Users\\dzouz\\Pictures\\Memes\\contracts" + i + "_.png");
            ImageIO.write(image, "png", output);
            i++;
            return output;
        }
        return null;
    }

    public File flipImage(File file) throws Exception {
        if (file.exists()) {
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            BufferedImage outputImage = ImageIO.read(file);
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    Color color = new Color(pixel);
                    outputImage.setRGB(image.getWidth() - x - 1, y, color.getRGB());
                }
            }
            File output = new File("C:\\Users\\dzouz\\Pictures\\Memes\\contracts" + i + "_.png");
            ImageIO.write(outputImage, "png", output);
            i++;
            return output;
        }
        return null;
    }

}
