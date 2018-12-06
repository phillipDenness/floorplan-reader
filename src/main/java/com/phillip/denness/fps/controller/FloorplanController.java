package com.phillip.denness.fps.controller;

import com.phillip.denness.fps.Service.FloorplanService;
import com.phillip.denness.fps.domain.Floorplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/floor-plan")
public class FloorplanController {

    @Autowired
    private FloorplanService floorplanService;

    @CrossOrigin
    @PostMapping(value = "")
    public ResponseEntity<Floorplan> postSearchTerms(@RequestBody Floorplan floorplan) {
        floorplanService.processImage(floorplan);
        return new ResponseEntity(floorplan, HttpStatus.CREATED);
    }
}
