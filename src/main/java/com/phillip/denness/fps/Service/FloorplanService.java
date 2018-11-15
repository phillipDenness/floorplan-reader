package com.phillip.denness.fps.Service;

import com.phillip.denness.fps.domain.Floorplan;
import com.phillip.denness.fps.repository.FloorplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorplanService {

    private FloorplanRepository floorplanRepository;

    @Autowired
    public FloorplanService(FloorplanRepository floorplanRepository) {
        this.floorplanRepository = floorplanRepository;
    }

    public List<Floorplan> getAllFloorplans() {
        return floorplanRepository.findAll();
    }

    public Floorplan createFloorplan(Floorplan floorplan) {
        return floorplanRepository.save(floorplan);
    }

    public Optional<Floorplan> getFloorplan(Integer id) {
        return floorplanRepository.findById(id);
    }
}
