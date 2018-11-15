package com.phillip.denness.fps.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "floorplans")
public class Floorplan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "floorplan_id")
    private Integer floorplanId;

    @Column(name = "search_name")
    private String searchName;

    @Column(name = "domain")
    private String domain;

    @ElementCollection
    @CollectionTable(
            name="searchterms_keywords",
            joinColumns=@JoinColumn(name = "searchterms_search_terms_id", referencedColumnName = "search_terms_id")
    )
    @Column(name = "keywords")
    protected Set<String> keywords = new HashSet();

    @ElementCollection
    @CollectionTable(
            name="searchterms_blockwords",
            joinColumns=@JoinColumn(name = "searchterms_search_terms_id", referencedColumnName = "search_terms_id")
    )
    @Column(name = "blockwords")
    protected Set<String> blockwords = new HashSet();

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(Integer floorplanId) {
        this.floorplanId = floorplanId;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Set<String> getBlockwords() {
        return blockwords;
    }

    public void setBlockwords(Set<String> blockwords) {
        this.blockwords = blockwords;
    }
}
