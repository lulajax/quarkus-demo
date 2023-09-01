package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.data.WxArtwordTag;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/hello")
public class GreetingResource {

    @Autowired
    private WxArtwordTagService artwordTagService;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        artwordTagService.list();
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/tag/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<WxArtwordTag> tagList() {
        return artwordTagService.list();
    }
}
