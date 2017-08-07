import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

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
      int px, py;
      for (int x = 0; x < img.getWidth(); x++) {
         for (int y = 0; y < img.getHeight(); y++) {
            px = x-960;
            py = 540-y;
            if (isMandle(px, py)){
               img.setRGB(x, y, Color.RED.getRGB());
               pane.repaint();
            }
         }
      }
   }

   public static boolean isMandle(int x, int y){
      ComplexNumber seed = new ComplexNumber(x,y);
      ComplexNumber i = ComplexNumber.func(seed, new ComplexNumber(0,0));
      for (int j = 0; j<10; j++) i = ComplexNumber.func(seed,i);
      return i.getAbsolute()<=2;
   }
}
