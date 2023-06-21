package Application.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.List;

public class ChatGPTBot {
    private static final String API_URL = "https://api.openai.com/v1/engines/davinci-codex/completions";

    public static String chatGPT(String text) throws Exception {
        OpenAiService openAiService = new OpenAiService("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", Duration.ofSeconds(10));
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder().model("gpt-3.5-turbo").temperature(0.8).messages(
                List.of(new ChatMessage("system", text))).build();
        StringBuilder builder = new StringBuilder();
        openAiService.createChatCompletion(chatCompletionRequest)
                .getChoices().forEach(choice -> {
                    builder.append(choice.getMessage().getContent());
                });
        String jsonResponse = builder.toString();
        return jsonResponse;
    }
}
