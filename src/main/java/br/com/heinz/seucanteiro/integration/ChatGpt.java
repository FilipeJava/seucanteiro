package br.com.heinz.seucanteiro.integration;

import br.com.heinz.seucanteiro.integration.request.ChatGptRequest;
import br.com.heinz.seucanteiro.integration.request.Message;
import br.com.heinz.seucanteiro.integration.response.ChatGptResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGpt {

	@Value("${gpt.apiKey}")
	private String apiKey;

	private final RestTemplate restTemplate;

	public ChatGpt() {
		this.restTemplate = new RestTemplate();
	}

	public String sendMessage(String message) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + apiKey);

		ChatGptRequest chatGptRequest = new ChatGptRequest();
		chatGptRequest.setModel("gpt-3.5-turbo");
		chatGptRequest.addMessage(new Message("system", "You are an assistant who answers questions about planting, growing, and harvesting only"));
		chatGptRequest.addMessage(new Message("user", message));

		HttpEntity<ChatGptRequest> httpRequest = new HttpEntity<>(chatGptRequest, headers);

		ResponseEntity<ChatGptResponse> response = restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", httpRequest, ChatGptResponse.class);

		ChatGptResponse chatGptResponse = response.getBody();

		return chatGptResponse.getChoices().get(0).getMessage().getContent();
	}
}
