/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.accessibility.Accessible;
import javax.swing.JComponent;

import javax.swing.JFileChooser;
import layout.bgf1;
/**
 *
 * @author Vaidehi
 */
public class EXtra_FileChooserTest_net{
     public static void main(String[] args) {
 bgf1 b=new bgf1();
 b.browse1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser fileChooser = new JFileChooser();
      /*  ExampleFileFilter filter = new ExampleFileFilter();
        filter.addExtension("jpg");
        filter.addExtension("gif");
        filter.setDescription("JPG & GIF Images");
    filechooser.setFileFilter(filter);*/
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          System.out.println(selectedFile.getName());
        }
      }
    });
     }
}
