package com.thouthworks.felix.services.eureka.sor;

import java.net.URI;

public abstract class Routes {
    private final String baseUri = "http://localhost";

    public static URI imageUri(Long imageId) {
        return URI.create("/iamges/" + imageId);
    }

}
