package gui;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.AbstractAction;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 * @author Snaevar
 * 
 * This class creates a display element that displays images of a single hotel
 * based on the integer value received by the object.
 *
 */
public class DisplayImages extends JFrame {

    private JLabel photographLabel = new JLabel();
    private JToolBar buttonBar = new JToolBar();
    private MissingIcon placeholderIcon = new MissingIcon();
    private static int substring_size = 17;
    
    //Default settings
    int hotelnumber = 1;
    String imagedir = "images/" + hotelnumber + "/";
    String[] imageCaptions = {
        "Default Image 1",
        "Default Image 2",
        "Default Image 3",
        "Default Image 4",
        "Default Image 5"};

    String[] imageFileNames = {
        "Hilton_Reykjavik_Nordica_01.jpg",
        "Hilton_Reykjavik_Nordica_02.jpg",
        "Hilton_Reykjavik_Nordica_03.jpg",
        "Hilton_Reykjavik_Nordica_04.jpg",
        "Hilton_Reykjavik_Nordica_05.jpg"};
    
    /**
     * Main method. Loads the Swing elements on the "Event Dispatch Thread".
     *
     * @param args
     */
    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DisplayImages app = new DisplayImages(9);
                app.setVisible(true);                
            }
        });

    }
    
    /**
     * 
     * Class constructor.
     * 
     * @param hotelnr
     */
    public DisplayImages(int hotelnr) {
        
        imagedir = "images/" + hotelnr + "/";
        imageCaptions = getImageNamesOnly(hotelnr);
        imageFileNames = getImageNamesFileNames(hotelnr);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hotel Photo Display: Please Select an Image");
        
        // A label for displaying the pictures
        photographLabel.setVerticalTextPosition(JLabel.BOTTOM);
        photographLabel.setHorizontalTextPosition(JLabel.CENTER);
        photographLabel.setHorizontalAlignment(JLabel.CENTER);
        photographLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // Adds two glue components. Later in process(), will add thumbnail buttons
        // to the toolbar in between these glue components. This will center the
        // buttons in the toolbar.
        buttonBar.add(Box.createGlue());
        buttonBar.add(Box.createGlue());
        add(buttonBar, BorderLayout.SOUTH);
        add(photographLabel, BorderLayout.CENTER);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centers the frame on the screen
        loadimages.execute(); // Start the image loading SwingWorker in a background thread
    }
    
    /**
     * SwingWorker class that loads the images in a background thread and calls publish
     * when a new one is ready to be displayed.
     *
     * Using Void as the first SwingWorker parameter as we do not need to return
     * anything from doInBackground().
     */
    private SwingWorker<Void, ThumbnailAction> loadimages = new SwingWorker<Void, ThumbnailAction>() {

        /**
         * Creates full size and thumbnail versions of the target image files.
         */
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i < imageCaptions.length; i++) {
                ImageIcon icon;
                icon = createImageIcon(imagedir + imageFileNames[i], imageCaptions[i]);
                
                ThumbnailAction thumbAction;
                if(icon != null){
                    
                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(), 32, 32));                    
                    thumbAction = new ThumbnailAction(icon, thumbnailIcon, imageCaptions[i]);
                    
                }else{
                    // The image failed to load for some reason so load a placeholder instead
                    thumbAction = new ThumbnailAction(placeholderIcon, placeholderIcon, imageCaptions[i]);
                }
                publish(thumbAction);
            }
            // Unfortunately, we must return something, and only null is valid to
            // return when the return type is void.
            return null;
        }
        
        /**
         * Process all loaded images.
         */
        @Override
        protected void process(List<ThumbnailAction> chunks) {
            for (ThumbnailAction thumbAction : chunks) {
                JButton thumbButton = new JButton(thumbAction);
                // add the new button BEFORE the last glue
                // this centers the buttons in the toolbar
                buttonBar.add(thumbButton, buttonBar.getComponentCount() - 1);
            }
        }
    };
    
    /**
     * Creates an ImageIcon if the path is valid.
     * @param String - resource path
     * @param String - description of the file
     */
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
                
    /**
     * Action class that shows the image specified in its constructor.
     */
    private class ThumbnailAction extends AbstractAction{
        
        /**
         *The icon of the full image to display.
         */
        private Icon displayPhoto;
        
        /**
         * @param Icon - The full size photo to show in the button.
         * @param Icon - The thumbnail to show in the button.
         * @param String - The descriptioon of the icon.
         */
        public ThumbnailAction(Icon photo, Icon thumb, String desc){
            displayPhoto = photo;
            
            // The short description becomes the tooltip of a button.
            putValue(SHORT_DESCRIPTION, desc);
            
            // The LARGE_ICON_KEY is the key for setting the
            // icon when an Action is applied to a button.
            putValue(LARGE_ICON_KEY, thumb);
        }
        
        /**
         * Shows the full image in the main area and sets the application title.
         */
        public void actionPerformed(ActionEvent e) {
            photographLabel.setIcon(displayPhoto);
            setTitle(getValue(SHORT_DESCRIPTION).toString());
        }
    }

    /**
     * Use from parent class to set the hotelnr variable.
     */    
    public void setHotelnr(int hotelnr) {
        this.hotelnumber = hotelnr;
    }
    
    private static String getFullDirectory(int hotelnr) {
        return "src/gui/images/" + Integer.toString(hotelnr) + "/";
    }

    private static String[] getImageNamesOnly(int hotelnr) {
        
        File path = new File(getFullDirectory(hotelnr));
        File[] imgfiles_file = path.listFiles();
        String[] imgfiles = new String[imgfiles_file.length];
        for (int i = 0; i < imgfiles_file.length; i++) {
            imgfiles[i] = imgfiles_file[i].toString();
            imgfiles[i] = imgfiles[i].substring(substring_size);
            imgfiles[i] = imgfiles[i].replaceAll("[_]"," ");
            imgfiles[i] = imgfiles[i].replaceAll("[.jpg]","");
        }    
        return imgfiles;
    }
    
    private static String[] getImageNamesFileNames(int hotelnr) {
        
        File path = new File(getFullDirectory(hotelnr));
        File[] imgfiles_file = path.listFiles();
        String[] imgfiles = new String[imgfiles_file.length];
        for (int i = 0; i < imgfiles_file.length; i++) {
            imgfiles[i] = imgfiles_file[i].toString();
            imgfiles[i] = imgfiles[i].substring(substring_size);
        }    
        return imgfiles;
    }

    private static String[] getImageNamesFullPath(int hotelnr) {

        File path = new File(getFullDirectory(hotelnr));
        File[] imgfiles_file = path.listFiles();
        String[] imgfiles_fullpath = new String[imgfiles_file.length];
        for (int i = 0; i < imgfiles_file.length; i++) {
            imgfiles_fullpath[i] = imgfiles_file[i].toString();
        }        
        return imgfiles_fullpath;
    }
    
    private static String[] getRelativeImageFilePath(String[] stringArray) {
        String[] relativePath = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            relativePath[i] = stringArray[i].substring(substring_size);
        }
        return relativePath;
    }
    
    private static void printArray(String[] stringArray) {
            for (int i = 0; i < stringArray.length; i++) {
                System.out.println(stringArray[i]);
            }
    }
    
    private String getImagedir() {
        return this.imagedir;
    }
    
}
