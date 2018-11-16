package com.phillip.denness.fps.tesseract;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URISyntaxException;
import static org.junit.Assert.assertThat;

public class TesseractFpsTest {

    @Autowired
    private TesseractFps tesseractFps;

    @Before
    public void setUp() {

    }
//
//    @Test
//    public void testReadJpgImageText() throws URISyntaxException {
//        String readText = tesseractFps.getImgText("floorplan.jpg");
//        assertThat(readText, CoreMatchers.containsString("Gross internal floor area excluding Cellar (approx.): 75.3 sqm (810 sq ft)"));
//    }
//
//    @Test
//    public void testReadGifImageText() throws URISyntaxException {
//        String readText = tesseractFps.getImgText("floorplan.gif");
//        assertThat(readText, CoreMatchers.containsString("TOTAL APPROX. FLOOR AREA 134.5 SQ.M. (1448 SQ.FT.)"));
//    }
}
