package com.sazuluaga.automatizacion.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Credentials {
    private final String username;
    private final String password;
}
