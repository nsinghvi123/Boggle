package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SolveBoggleApiService;
import io.swagger.api.factories.SolveBoggleApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.BoggleWord;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/solve-boggle")


@io.swagger.annotations.Api(description = "the solve-boggle API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-07-13T22:01:30.048Z")
public class SolveBoggleApi  {
   private final SolveBoggleApiService delegate;

   public SolveBoggleApi(@Context ServletConfig servletContext) {
      SolveBoggleApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SolveBoggleApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SolveBoggleApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = SolveBoggleApiServiceFactory.getSolveBoggleApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "takes a picture and attempts to play boggle on the board", notes = "", response = BoggleWord.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = BoggleWord.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
    public Response solveBoggle(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.solveBoggle(securityContext);
    }
}
