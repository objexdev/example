package net.objex.example.jaxrs;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mazharchoudhry on 2016-11-20.
 */
@Path("/product")
public class ProductService {
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getProducts() {
        return Json.createArrayBuilder()
                .add( Json.createObjectBuilder()
                        .add( "1", "iPhone" )
                        .add( "2", "Macbook Pro" )
                        .add( "3", "Glaxy tab S" ) )
                .build();
    }
}