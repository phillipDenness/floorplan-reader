package com.phillip.denness.fps.controller;

import com.phillip.denness.fps.Service.FloorplanService;
import com.phillip.denness.fps.domain.Floorplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floor-plan")
public class FloorplanController {

    @Autowired
    private FloorplanService floorplanService;
//
//    @Autowired
//    private BasicWebCrawler basicWebCrawler;

    @GetMapping(value = "")
    public List<Floorplan> getAllFloorplans() {
        List<Floorplan> allFloorplans = floorplanService.getAllFloorplans();
        return allFloorplans;
    }

//    @PostMapping(value = "")
//    public FloorplanResponse postSearchTerms(@RequestBody Floorplan searchTermsBody) {
//        Floorplan searchterms = floorplanService.createSearchTerms(searchTermsBody);
//        Set<Scrape> scrapes = basicWebCrawler.doScrape(searchterms);
//
//        return new FloorplanResponse(searchterms, scrapes);
//    }
//
//    @GetMapping(value = "/{id}")
//    public FloorplanResponse getSearchTermsScrapes(@PathVariable(value="id") final Integer id) {
//        Optional<Floorplan> optionalSearchterms = floorplanService.getSearchTerms(id);
//        return optionalSearchterms.map(
//                searchterms -> {
//                    return new FloorplanResponse(searchterms, basicWebCrawler.doScrape(searchterms));
//                }
//                ).orElse(new FloorplanResponse());
//    }
}
