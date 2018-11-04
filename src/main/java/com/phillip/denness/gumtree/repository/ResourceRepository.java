package com.phillip.denness.gumtree.repository;

import com.phillip.denness.gumtree.domain.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Integer> {

    @Override
    List<Resource> findAll();

}
