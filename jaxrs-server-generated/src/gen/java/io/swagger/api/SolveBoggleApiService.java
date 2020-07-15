package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.BoggleBoard;
import io.swagger.model.BoggleWord;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-07-15T19:50:05.497Z")
public abstract class SolveBoggleApiService {
    public abstract Response solveBoggle(BoggleBoard boggleBoard,SecurityContext securityContext) throws NotFoundException;
}
