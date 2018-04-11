package com.thouthworks.felix.services.eureka.sod.rest;

import com.thouthworks.felix.services.eureka.sod.domain.ApprovalService;
import com.thouthworks.felix.services.eureka.sod.domain.Uploading;
import com.thouthworks.felix.services.eureka.sod.domain.UploadingRepository;
import com.thouthworks.felix.services.eureka.sod.rest.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.thouthworks.felix.services.eureka.sod.Routes.approvalUri;
import static com.thouthworks.felix.services.eureka.sod.Routes.uploadingUri;

@RestController
@RequestMapping("/uploadings")
public class UploadingsApi {

    @Autowired
    UploadingRepository repository;

    @Autowired
    ApprovalService approvalService;

    @PostMapping
    public ResponseEntity uploadText(@RequestParam("content") String text) {
        final Uploading uploading = new Uploading(text);
        final Uploading saved = repository.save(uploading);
        return ResponseEntity.created(uploadingUri(saved.getId())).build();
    }

    @GetMapping
    public ResponseEntity<List<Uploading>> listUploadings() {
        final List<Uploading> all = repository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity showUploading(@PathVariable("id") Long id) {
        final Optional<Uploading> optionalUploading = repository.findById(id);
        return optionalUploading
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("uploading not found"));
    }

    @PostMapping(value = "{id}/approval")
    public ResponseEntity approval(@PathVariable("id") Long id) {
        final Optional<Uploading> optionalUploading = repository.findById(id);
        if (!optionalUploading.isPresent()) {
            throw new NotFoundException("uploading not found");
        }

        final Uploading found = optionalUploading.get();
        approvalService.approval(found);
        return ResponseEntity.created(approvalUri(found.getId())).build();
    }
}
