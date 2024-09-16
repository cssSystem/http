package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.util.List;

public class JsonJava {
    private ObjectMapper mapper = new ObjectMapper();

    private CloseableHttpResponse response;

    public JsonJava(CloseableHttpResponse response) {
        this.response = response;
    }

    public List toJavaList() throws IOException {
        List<Post> posts = mapper.readValue(
                response.getEntity().getContent(), new
                        TypeReference<>() {
                        });
        return posts;
    }
}
