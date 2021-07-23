/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author unouser
 */
public class starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Constructor: width, height, pixel format
        try {
        
        BufferedImage bufferedImage = ImageIO.read(new File("bridge.jpg"));
        //BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        
        for(int i =0; i < 200; i++)
        {
            bufferedImage.setRGB(i, i, Color.BLUE.getRGB());
            
        }
        
        
            ImageIO.write(bufferedImage, "PNG", new File("out.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}