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
      BufferedImage img = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
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
      for (int i = 600; i<3850; i++){
          drawImage(img, pane, Math.pow(1.01,i));
          //Save image
          try {
             File outputfile = new File((i-599)+".png");
             System.out.println("Written: " +i+".png");
             ImageIO.write(img, "png", outputfile);
          } catch (IOException e) {}
      }
   }

   public static void drawImage(BufferedImage img, JPanel pane, double zoom){
      int px, py;
      int colour;
      int min_colour = isMandle(0,0);

      for (int x = 0; x < img.getWidth(); x++) {
         for (int y = 0; y < img.getHeight(); y++) {
            px = x-960;
            py = 540-y;
            colour = isMandle(px/zoom, py/zoom);
            if (min_colour > colour) min_colour = colour;
            // colour = convRGB(colour);
            // System.out.println(colour);
            img.setRGB(x, y, colour);
            // pane.repaint();
         }
      }

      for (int x = 0; x < img.getWidth(); x++) {
         for (int y = 0; y < img.getHeight(); y++) {
            img.setRGB(x, y, img.getRGB(x,y)-min_colour);
         }
      }
      pane.repaint();
   }

   public static int convRGB(int colour){
      Color n = Color.getHSBColor(10,10,colour);
      return n.getRGB();
   }

   public static int isMandle(double x, double y){
      ComplexNumber seed = new ComplexNumber(x+0.3501008,y-0.51209);
      ComplexNumber i = ComplexNumber.func(seed, new ComplexNumber(0,0));

      int j = 0;
      while (i.getAbsolute() < 2){
         i = ComplexNumber.func(seed,i);
         j++;
         if (j>1000) return j;
      }
      return j;
   }
}
