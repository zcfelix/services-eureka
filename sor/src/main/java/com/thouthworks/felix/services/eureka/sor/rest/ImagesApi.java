package com.thouthworks.felix.services.eureka.sor.rest;

import com.thouthworks.felix.services.eureka.sor.domain.Image;
import com.thouthworks.felix.services.eureka.sor.domain.ImageRepository;
import com.thouthworks.felix.services.eureka.sor.rest.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.thouthworks.felix.services.eureka.sor.Routes.imageUri;

@RestController
@RequestMapping("/images")
public class ImagesApi {

    @Autowired
    private ImageRepository repository;

    @PostMapping
    public ResponseEntity createImage(@RequestParam("content") String content) {
        final Image image = new Image(content);
        final Image saved = repository.save(image);
        return ResponseEntity.created(imageUri(saved.getId())).build();
    }

    @GetMapping
    public ResponseEntity<List<Image>> listImages() {
        final List<Image> all = repository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Image> showImage(@PathVariable("id") Long id) {
        final Optional<Image> optionalUploading = repository.findById(id);
        return optionalUploading
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("uploading not found"));
    }
}
