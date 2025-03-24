package com.pck.genai.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.pck.genai.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmbeddingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void testMatchServices() throws Exception {
        ChatRequest request = new ChatRequest();
        request.setModel("text-embedding-ada-002");
        request.setTemperature(0.7);
        request.setMax_tokens(200);
        request.setTop_p(1.0);
        request.setFrequency_penalty(0.0);
        request.setPresence_penalty(0.0);
        request.setMessages(List.of(new ChatMessage("user", "I need scalable compute and storage services")).toArray(new ChatMessage[0]));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(request);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:"+port+"/embedding/match", HttpMethod.POST, entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        List<String> matchedIds = objectMapper.readValue(response.getBody(), List.class);
        for (String id: matchedIds){
            System.out.println("Matched service id: "+id);
        }
        assertFalse(matchedIds.isEmpty(), "No matching services found");
    }
}

