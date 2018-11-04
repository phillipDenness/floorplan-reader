package com.phillip.denness.gumtree.controller;


import com.phillip.denness.gumtree.Service.ResourceService;
import com.phillip.denness.gumtree.domain.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ResourceControllerTest {

    @Mock
    private ResourceService resourceService;

    @InjectMocks
    private ResourceController resourceController;

    @Autowired
    private MockMvc mockMvc;

    final private String ENDPOINT = "/resources";

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(resourceController).build();

        Resource testResource = new Resource();
        testResource.setName("testResource");
        testResource.setUrl("http://testResource.com");
        testResource.setResourceId(1);

        Resource testResource2 = new Resource();
        testResource.setName("testResource2");
        testResource.setUrl("http://testResource.com");
        testResource.setResourceId(2);

        List<Resource> testResources = Arrays.asList(testResource, testResource2);
        given(resourceService.getAllResources()).willReturn(testResources);
    }

    @Test
    public void testGetResourcesReturns200Response() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT))
                            .andExpect(status().is2xxSuccessful())
                            .andReturn();
    }
}
