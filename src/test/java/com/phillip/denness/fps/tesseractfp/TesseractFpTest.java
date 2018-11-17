package com.phillip.denness.fps.tesseractfp;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;

import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TesseractFpTest {

    @Autowired
    private TesseractFp tesseractFps;

    @Before
    public void setUp() {

    }

    @Test
    public void testReadJpgImageText() throws URISyntaxException {
        String readText = tesseractFps.getImgText("floorplan.jpg");
        assertThat(readText, CoreMatchers.containsString("Gross internal floor area excluding Cellar (approx.): 75.3 sqm (810 sq ft)"));
    }

    @Test
    public void testReadGifImageText() throws URISyntaxException {
        String readText = tesseractFps.getImgText("floorplan.gif");
        assertThat(readText, CoreMatchers.containsString("TOTAL APPROX. FLOOR AREA 134.5 SQ.M. (1448 SQ.FT.)"));
    }
}
