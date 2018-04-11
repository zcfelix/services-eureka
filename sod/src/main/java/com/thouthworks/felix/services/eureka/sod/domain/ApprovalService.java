package com.thouthworks.felix.services.eureka.sod.domain;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ApprovalService {
    public static final String URL = "http://localhost:8081/images";
    private RestTemplate restTemplate = new RestTemplate();

    public void approval(Uploading uploading) {
        final HttpEntity<MultiValueMap<String, Object>> requestEntity = generateRequestEntity(uploading);
        restTemplate.exchange(URL, HttpMethod.POST, requestEntity, ResponseEntity.class);
    }

    private HttpEntity<MultiValueMap<String, Object>> generateRequestEntity(Uploading uploading) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("content", uploading.getContent());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        return new HttpEntity<>(params, headers);
    }
}
