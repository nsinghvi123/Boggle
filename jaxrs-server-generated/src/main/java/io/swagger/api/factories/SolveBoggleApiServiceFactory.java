package io.swagger.api.factories;

import io.swagger.api.SolveBoggleApiService;
import io.swagger.api.impl.SolveBoggleApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-07-13T22:01:30.048Z")
public class SolveBoggleApiServiceFactory {
    private final static SolveBoggleApiService service = new SolveBoggleApiServiceImpl();

    public static SolveBoggleApiService getSolveBoggleApi() {
        return service;
    }
}
