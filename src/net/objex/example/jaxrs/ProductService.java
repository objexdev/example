package net.objex.example.jaxrs;

import org.hibernate.loader.custom.Return;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.ws.rs.core.Response.ok;

/**
 * Created by mazharchoudhry on 2016-11-20.
 */
@Path("/product")
public class ProductService {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPAJAXRS");
    EntityManager entityManager;
    @GET
    @Path("save")
    /**
     * Persistence example
     */
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray generate() {
        entityManager = entityManagerFactory.createEntityManager();
        Product p1 = new Product(1, "iPhone");
        Product p2 = new Product(2, "Macbook Pro");
        Product p3 = new Product(3, "Galaxy Tab 10");
        ArrayList<Product> products = new ArrayList();
        products.add(p1);
        products.add(p2);
        products.add(p3);

            try{
                for (Product product:products) {
                    entityManager.getTransaction().begin();
                    entityManager.persist(product);
                    entityManager.getTransaction().commit();
                }
            }catch(Throwable t){
                if(entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            }finally{
                entityManager.close();
            }
        return jsonArray(products);
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List getProducts() {
        entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("SELECT x from Product x");
        List list = (List) q.getResultList();
        return jsonArray(list);
    }

    @GET
    @Path("/{productId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Product getContact(@PathParam("productId") int productId) {
        entityManager = entityManagerFactory.createEntityManager();
        Product product = entityManager.find(Product.class, productId);
        return product;
    }

    private JsonArray jsonArray(List<Product> products) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Product product:products) {
            builder.add(Json.createObjectBuilder().add(Integer.toString(product.getId()), product.getName()));
        }
        return builder.build();
    }
}