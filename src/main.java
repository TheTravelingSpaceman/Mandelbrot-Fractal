import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class main{
   public static void main(String[] args){

      //Setup Jframe
      JFrame frame = new JFrame("JFrame Example");
      frame.setLocationRelativeTo(null);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 500);
      frame.setVisible(true);

      //Display Image
      BufferedImage img = new BufferedImage(1920*4, 1080*4, BufferedImage.TYPE_INT_RGB);
      JPanel pane = new JPanel() {
         @Override
         protected void paintComponent(Graphics g) {
             super.paintComponent(g);
             g.drawImage(img, 0, 0, null);
         }
      };
      pane.setSize(1920, 1080);
      frame.add(pane);

      //Draw Image
      int px, py;
      int colour;
      for (int x = 0; x < img.getWidth(); x++) {
         for (int y = 0; y < img.getHeight(); y++) {
            px = x-960;
            py = 540-y;
            colour = isMandle(px, py);
            // System.out.println(colour);
            img.setRGB(x, y, colour);
            pane.repaint();
         }
      }

      //Save image
      try {
         File outputfile = new File("saved.png");
         ImageIO.write(img, "png", outputfile);
      } catch (IOException e) {}
   }

   public static int isMandle(int x, int y){
      ComplexNumber seed = new ComplexNumber(x/800000.0-0.79,y/800000.0-0.16);
      ComplexNumber i = ComplexNumber.func(seed, new ComplexNumber(0,0));

      int j = 0;
      while (i.getAbsolute() < 2){
         i = ComplexNumber.func(seed,i);
         j++;
         if (j>100000) break;
      }
      return j;
   }
}
