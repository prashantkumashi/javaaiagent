package com.pck.genai.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiConfig {

    @Value("${openai.api.key}")
    private String openApiKey;

    @Value("${openai.api.organization}")
    private String openApiOrganization;

    @Value("${openai.api.project}")
    private String openApiProject;

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + this.openApiKey);
        headers.set("OpenAI-Organization", this.openApiOrganization);
        headers.set("OpenAI-Project", this.openApiProject);
        return headers;
    }
}
