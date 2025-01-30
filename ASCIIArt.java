
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ASCIIArt {

    private final String pixel_ascii_map = "'^ ;Ii~+_-\\?\\]\\[1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%\\$";

    public static BufferedImage resizeImage(BufferedImage image, int newLength, int newWidth) {
        
        BufferedImage resizedimage = new BufferedImage(newWidth, newLength, image.getType());

        Graphics2D g = resizedimage.createGraphics();
        g.drawImage(image, 0, 0, newWidth, newLength, null);
        g.dispose();

        return resizedimage;
    }
    
    public String[] generatorASCIIArt(File imageFile) throws IOException{

        //step 1: Load
        BufferedImage image = ImageIO.read(imageFile);

        //step 2: Resize   
        int newwidth = 100;
        int newlength = (int) ((double) newwidth / image.getWidth() * image.getHeight());
 
        BufferedImage resizedImage = resizeImage(image, newlength, newwidth);

        //step 3: covert to ascii
       String[] ASCIIimage = new String[newlength];

       for (int i = 0; i < newlength; i++) {
           StringBuilder store = new StringBuilder();
           for (int j = 0; j < newwidth; j++) {
               int rgb = resizedImage.getRGB(j, i);

               int red = (rgb >> 16) & 0xFF;
               int green = (rgb >> 8) & 0xFF;
               int blue = rgb & 0xFF;

               int rgbAvg = (red + green + blue) / 3;

               int index = rgbAvg * (pixel_ascii_map.length() - 1) / 255;

               store.append(pixel_ascii_map.charAt(index));

           }
           ASCIIimage[i] = store.toString();
       }
        
       return ASCIIimage;
    }

    public static void main (String[] args) throws IOException {

        File imagFile = new File("/Users/dixansh/Desktop/Projects/Java_Project/image6.jpg");
ASCIIArt art = new ASCIIArt();
String[] ASCIIimage = art.generatorASCIIArt(imagFile);

for (String string : ASCIIimage) {
    System.out.println(string);
        }
    }
}