package com.thouthworks.felix.services.eureka.sod;

import java.net.URI;

public abstract class Routes {
    private final String baseUri = "http://localhost";

    public static URI uploadingUri(Long uploadingId) {
        return URI.create("/uploadings/" + uploadingId);
    }
}
