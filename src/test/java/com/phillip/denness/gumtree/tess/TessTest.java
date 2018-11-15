package com.phillip.denness.gumtree.tess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.net.URL;

@RunWith(SpringRunner.class)
public class TessTest {

    private Tess tess;

    @Before
    public void setUp() {
        this.tess = new Tess();
    }

    @Test
    public void testReadImageText() throws URISyntaxException {
        URL defaultImage = TessTest.class.getResource("floorplan.jpg");
        String readText = tess.getImgText(defaultImage);
    }
}
