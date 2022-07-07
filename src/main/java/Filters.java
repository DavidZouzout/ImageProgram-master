import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Filters extends JPanel {
    /* Please put the file location where you'd like to store your filtered images, after the "File userFileLocation = new File(..." */
    File userFileLocation = new File("C:\\Users\\dzouz\\Pictures\\Memes");
    File output;
    Color color;
    BufferedImage image;
    int i = 1;

    public File colorShiftRight(File file) throws Exception {
        if (file.exists()) {
            image = ImageIO.read(file);// כדי להשתמש בתמונה
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(green, blue, red);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            output = new File(userFileLocation+"\\ColorShiftRight_" + i + "_.png");
            System.out.println(output);
            ImageIO.write(image, "png", output);
            i++;
            return output;
        }
        return null;// סוגר שבודק האם הקובץ קיים
    }// end of the changeColor function

    public File colorShiftLeft(File file) throws Exception {
        if (file.exists()) {
            image = ImageIO.read(file);
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(blue, red, green);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            output = new File(userFileLocation+"\\ColorShiftLeft_" + i + "_.png");
            ImageIO.write(image, "png", output);
            i++;
            return output;
        }
        return null;
    }

    public File sepia(File file) throws Exception {
        if (file.exists()) {
            image = ImageIO.read(file);// כדי להשתמש בתמונה
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    int avg = (red + green + blue) / 3;
                    int depth = 20;
                    int intensity = 30;
                    red = avg + (depth * 2);
                    green = avg + depth;
                    blue = avg - intensity;
                    if (red > 255) red = 255;
                    if (green > 255) green = 255;
                    if (blue > 255) blue = 255;
                    if (blue < 0) blue = 0;
                    Color newColor = new Color(red, green, blue);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            //Saving the modified image
            output = new File(userFileLocation+"\\Sepia_" + i + "_.png");
            ImageIO.write(image, "png", output);
            i++;
            return output;

        }
        return null;
    }

    public File greyScale(File file) throws Exception {
        if (file.exists()) {
            image = ImageIO.read(file);
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    int average = (red + green + blue) / 3;
                    Color newColor = new Color(average, average, average);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            output = new File(userFileLocation+"\\GreyScale_" + i + "_.png");
            ImageIO.write(image, "png", output);
            i++;
            return output;

        }
        return null;
    }

    public File contracts(File file) throws Exception {
        if (file.exists()) {
            image = ImageIO.read(file);
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(255 - red, 255 - green, 255 - blue);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            output = new File(userFileLocation+"\\Contracts_" + i + "_.png");
            ImageIO.write(image, "png", output);
            i++;
            return output;
        }
        return null;
    }

    public File flipImage(File file) throws Exception {
        if (file.exists()) {
            image = ImageIO.read(file);
            BufferedImage outputImage = ImageIO.read(file);
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    color = new Color(pixel);
                    outputImage.setRGB(image.getWidth() - x - 1, y, color.getRGB());
                }
            }
            output = new File(userFileLocation+"\\FlipImage_" + i + "_.png");
            ImageIO.write(outputImage, "png", output);
            i++;
            return output;
        }
        return null;
    }

}
