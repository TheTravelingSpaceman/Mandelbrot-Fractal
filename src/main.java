import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class main{
   public static void main(String[] args){

      //Setup Jframe
      JFrame frame = new JFrame("JFrame Example");
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 500);

      //Draw Image
      BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
      for (int x = 0; x < img.getWidth(); x++) {
         for (int y = 0; y < img.getHeight(); y++) {
            img.setRGB(x, y, Color.RED.getRGB());
         }
      }

      //Display Image
      JPanel pane = new JPanel() {
         @Override
         protected void paintComponent(Graphics g) {
             super.paintComponent(g);
             g.drawImage(img, 0, 0, null);
         }
      };
      pane.setSize(200, 200);
      frame.add(pane);
      System.out.println("Image Drawn!");

      frame.setVisible(true);
   }
}
