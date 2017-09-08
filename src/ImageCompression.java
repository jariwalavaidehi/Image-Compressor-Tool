
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
   public static void main(String[] args) throws IOException { 

/* 
* if (args.length < 2) { // Exit if both the arguments (Input File and 
* Output File) are not provided 
* System.err.println("Usage: java TestWriter c:\\in.png c:\\out.png"); 
* return; } 
*/ 
Iterator writers; 
BufferedImage bufferedImage; 
ImageOutputStream imageOutputStream; 
ImageWriter imageWriter; 
ImageWriteParam pngparams; 

// Read an image from the disk (First Argument) 
// bufferedImage = ImageIO.read(new File(args[0])); 
bufferedImage = ImageIO.read(new File("c://book//t1.jpg")); 
// Get all the PNG writers 
writers = ImageIO.getImageWritersByFormatName("jpg"); 

// Fetch the first writer in the list 
imageWriter = (ImageWriter) writers.next(); 


// Just to confirm that the writer in use is CLibPNGImageWriter 
System.out.println("\n Writer used : " 
+ imageWriter.getClass().getName() + "\n"); 

// Specify the parameters according to those the output file will be 
// written 

// Get Default parameters 
pngparams = imageWriter.getDefaultWriteParam(); 

// Define compression mode 
pngparams 
.setCompressionMode(javax.imageio.ImageWriteParam.MODE_EXPLICIT); 

// Define compression quality 
pngparams.setCompressionQuality(0.5F); 

// Define progressive mode 
pngparams 
.setProgressiveMode(javax.imageio.ImageWriteParam.MODE_COPY_FROM_METADATA); 

// Deine destination type - used the ColorModel and SampleModel of the 
// Input Image 
pngparams.setDestinationType(new ImageTypeSpecifier(bufferedImage 
.getColorModel(), bufferedImage.getSampleModel())); 

// Set the output stream to Second Argument 
// imageOutputStream = ImageIO.createImageOutputStream( new 
// FileOutputStream(args[1]) ); 
imageOutputStream = ImageIO 
.createImageOutputStream(new FileOutputStream("c://book//new_t1.jpg")); 
imageWriter.setOutput(imageOutputStream); 

// Write the changed Image 
imageWriter.write(null, new IIOImage(bufferedImage, null, null), 
pngparams); 

// Close the streams 
imageOutputStream.close(); 
imageWriter.dispose(); 
    } 
}
