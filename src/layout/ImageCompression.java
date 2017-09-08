package layout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vaidehi
 */
public class ImageCompression {
   File f;
   public static String s1="";
    ImageCompression(String path) throws Exception
    {
       System.out.println(s1); 
    Iterator writers; 
    BufferedImage bufferedImage; 
    ImageOutputStream imageOutputStream = null; 
    ImageWriter imageWriter; 
    ImageWriteParam jpgparams; 
        
    // Read an image from the disk (First Argument)

bufferedImage = ImageIO.read(new File(path)); 
// Get all the jpg writers 
       

writers = ImageIO.getImageWritersByFormatName("jpg"); 

// Fetch the first writer in the list 
imageWriter = (ImageWriter) writers.next(); 


// Just to confirm that the writer in use is CLibJPGImageWriter 
System.out.println("\n Writer used : "+ imageWriter.getClass().getName() + "\n"); 

/*Specify the parameters according to those the output file will be 
 written */

// Get Default parameters  
jpgparams = imageWriter.getDefaultWriteParam(); 

// Define compression mode 
jpgparams.setCompressionMode(javax.imageio.ImageWriteParam.MODE_EXPLICIT); 

// Define compression quality 
jpgparams.setCompressionQuality(0.5F); 

// Define progressive mode 
jpgparams 
.setProgressiveMode(javax.imageio.ImageWriteParam.MODE_COPY_FROM_METADATA); 

// Define destination type - used the ColorModel and SampleModel of the 
// Input Image 
jpgparams.setDestinationType(new ImageTypeSpecifier(bufferedImage.getColorModel(), bufferedImage.getSampleModel())); 

imageOutputStream = ImageIO.createImageOutputStream(new FileOutputStream("c://book//scan.jpg"));
       
imageWriter.setOutput(imageOutputStream);
// Write the changed Image 
imageWriter.write(null, new IIOImage(bufferedImage, null, null), 
jpgparams); 

// Close the streams 
imageOutputStream.close(); 
imageWriter.dispose(); 
}

}
