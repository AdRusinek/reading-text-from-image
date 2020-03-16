package com.rusinek;

import net.sourceforge.lept4j.util.LoadLibs;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Adrian Rusinek on 16.03.2020
 **/
public class TesseractExample {

    public static void main(String[] args) throws IOException {
        URL imageFile = new URL("https://i0.wp.com/sekretypiekna.com.pl/wp-content/uploads/2018/09/dziwne.jpg?resize=572%2C600&ssl=1");
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        ITesseract instance = new Tesseract();
        instance.setDatapath("C:\\Users\\Adrian\\Downloads\\");
        instance.setLanguage("pol");


        String result = null;
        try {
            result = instance.doOCR(bufferedImage);
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
