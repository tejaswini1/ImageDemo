package com.utility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class ImageScaler {

    public  BufferedImage resizeImage(BufferedImage image, int width, int height) throws IOException {
        int originalHeight=image.getHeight();
        int originalWidth=image.getWidth();
        float originalAspectRatio=(float)(originalWidth/originalHeight);
        float aspectRatio=width/height;
        if(aspectRatio!=originalAspectRatio) {
            height = (int)(width / originalAspectRatio);
        }
        BufferedImage resizedImage = new BufferedImage(width, height, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }
}