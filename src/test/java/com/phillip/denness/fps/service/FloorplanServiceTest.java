package com.phillip.denness.fps.service;

import com.phillip.denness.fps.Service.FloorplanService;
import com.phillip.denness.fps.domain.Floorplan;
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
public class FloorplanServiceTest {

    @Autowired
    private FloorplanService floorplanService;

    @Before
    public void setUp() {
    }

//    @Test
//    public void testFloorplanServiceUrl() throws URISyntaxException {
//        String url = "https://media.rightmove.co.uk/dir/111k/110981/67658092/110981_HORSP208151_FLP_01_0000_max_600x600.jpg";
//        Floorplan floorplan = new Floorplan();
//        floorplan.setUrl(url);
//        floorplanService.processImage(floorplan);
//    }

}
