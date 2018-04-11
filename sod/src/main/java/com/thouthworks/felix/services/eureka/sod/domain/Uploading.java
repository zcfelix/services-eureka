package com.thouthworks.felix.services.eureka.sod.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "uploadings")
public class Uploading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @JsonProperty("content")
    private String content;

    @JsonCreator
    private Uploading() {
    }

    public Uploading(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }
}
