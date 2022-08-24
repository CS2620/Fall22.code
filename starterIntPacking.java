import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Identical to class "starter", but we do the pick packing and unpacking manually
 */
public class starterIntPacking {

  public static void main(String[] args) {

    try {

      BufferedImage bufferedImage = ImageIO.read(new File("bridge.jpg"));

      // To create an image from scratch, use the following
      // BufferedImage bufferedImage = new BufferedImage(200, 200,
      // BufferedImage.TYPE_INT_ARGB);


      //Loop over every pixel
      for (int y = 0; y < bufferedImage.getHeight(); y++) {
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
          int pixelInt = bufferedImage.getRGB(x, y);
          
          //Just do a grayscale conversion for half the image
          if (x < bufferedImage.getWidth() / 2) {
            //Get the int [0,255] values for red, green, and blue
            int r = (pixelInt >> 16) & 0xFF;
            int g = (pixelInt >> 8) & 0xFF;
            int b = (pixelInt ) & 0xFF;

            //Do a trivial grayscale conversion by just using the red channel.
            g = r;
            b = r;

            int outInt = (r << 16) + (g << 8) + b;

            //Set the pixel to the color
            bufferedImage.setRGB(x, y, outInt);
          }
        }
      }

      //Draw a red rectangle on the image

      //Get the graphics context
      Graphics g = bufferedImage.getGraphics();

      //Draw the rectangle
      g.setColor(Color.RED);
      g.drawRect(10, 10, 100, 100);

      // Save the image to a file
      ImageIO.write(bufferedImage, "PNG", new File("out.png"));

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
} 