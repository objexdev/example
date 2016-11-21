package net.objex.example.jaxrs;

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
    public List<Product> getProducts() {
        return Arrays.asList(
                new Product(0, "", "motorola-xoom-with-wi-fi", "Motorola XOOM(tm) with Wi-Fi", "The Next, Next Generation\r\n\r\nExperience the future with Motorola XOOM with Wi-Fi, the world's first tablet powered by Android 3.0 (Honeycomb)."),
                new Product(1, "", "motorola-xoom", "MOTOROLA XOOM(tm)", "The Next, Next Generation\n\nExperience the future with MOTOROLA XOOM, the world's first tablet powered by Android 3.0 (Honeycomb)."),
                new Product(8, "", "samsung-galaxy-tab", "Samsung Galaxy Tab(tm)", "Feel Free to Tab(tm). The Samsung Galaxy Tab(tm) brings you an ultra-mobile entertainment experience through its 7\" display, high-power processor and Adobe(R) Flash(R) Player compatibility."),
                new Product(11, "Verizon", "droid-pro-by-motorola", "DROID(tm) Pro by Motorola", "The next generation of DOES."),
                new Product(18, "", "t-mobile-g2", "T-Mobile G2", "The T-Mobile G2 with Google is the first smartphone built for 4G speeds on T-Mobile's new network. Get the information you need, faster than you ever thought possible.")
        );

    }
}