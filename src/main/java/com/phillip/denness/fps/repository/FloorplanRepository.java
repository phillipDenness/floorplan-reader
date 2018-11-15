package com.phillip.denness.fps.repository;

import com.phillip.denness.fps.domain.Floorplan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorplanRepository extends CrudRepository<Floorplan, Integer> {

    @Override
    List<Floorplan> findAll();

}
