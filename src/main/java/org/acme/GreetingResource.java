package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    @Autowired
    private WxArtwordTagService artwordTagService;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/tag/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String tagList() throws JsonProcessingException {
        LOGGER.info("tagList");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(artwordTagService.list());
    }
}
