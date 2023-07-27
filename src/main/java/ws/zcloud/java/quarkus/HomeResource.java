package ws.zcloud.java.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Path("/")
public class HomeResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response home(@Context HttpHeaders headers) {
        return Response.ok(headers.getRequestHeaders().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, obj -> obj.getValue().stream()
                        .findFirst()
                        .orElse("")))).build();
    }
}
