package com.inc.smart.portal.openai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/faq")
    public String faq(@RequestParam(value = "message", defaultValue = "ITO 지식포털에 대해 설명해줘") String message) {

        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
