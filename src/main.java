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
      frame.setVisible(true);

      //Display Image
      BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
      JPanel pane = new JPanel() {
         @Override
         protected void paintComponent(Graphics g) {
             super.paintComponent(g);
             g.drawImage(img, 0, 0, null);
         }
      };
      pane.setSize(200, 200);
      frame.add(pane);

      //Draw Image
      for (int x = 0; x < img.getWidth(); x++) {
         for (int y = 0; y < img.getHeight(); y++) {
            try {
               Thread.sleep(10);
            }catch(InterruptedException e) {e.printStackTrace();}
            img.setRGB(x, y, Color.RED.getRGB());
            pane.repaint();
         }
      }
   }
}
