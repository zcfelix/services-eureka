package com.thouthworks.felix.services.eureka.sod.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "uploadings")
public class Uploading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created_at")
    @Column(name = "created_at")
    private Timestamp createdAt;

    @JsonCreator
    private Uploading() {
    }

    public Uploading(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
