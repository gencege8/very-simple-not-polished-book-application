package bookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int maxWidth = getWidth();
            int maxHeight = getHeight();

            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            double widthRatio = (double) maxWidth / imageWidth;
            double heightRatio = (double) maxHeight / imageHeight;

            double scale = Math.min(widthRatio, heightRatio);

            int scaledWidth = (int) (imageWidth * scale);
            int scaledHeight = (int) (imageHeight * scale);

            int x = (maxWidth - scaledWidth) / 2;
            int y = (maxHeight - scaledHeight) / 2;

            g.drawImage(image, x, y, scaledWidth, scaledHeight, this);
        }
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }
}
