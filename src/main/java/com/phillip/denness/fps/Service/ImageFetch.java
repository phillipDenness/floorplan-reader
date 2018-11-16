package com.phillip.denness.fps.Service;

import com.phillip.denness.fps.domain.Floorplan;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class ImageFetch {

    public BufferedImage download(Floorplan floorplan) throws IOException {
        InputStream in = new URL(floorplan.getUrl()).openStream();
        return ImageIO.read(in);
    }
}
