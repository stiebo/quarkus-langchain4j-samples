package dev.stiebo;

import io.quarkiverse.langchain4j.RegisterAiService;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

@RegisterAiService(modelName="m1")
public interface AiServiceM1 {

    @UserMessage("Tell me a dad joke")
    String getJoke();

    @SystemMessage("You are a poet")
    @UserMessage("""
                Provide a poem about {topic} that is exactly {lines} long.
            """)
    Poem writeAPoem(String topic, int lines);

    @SystemMessage("You are an agent for Wikipedia")
    @UserMessage("""
                Provide a definition for {topic}.
            """)
    TermDefinition writeDefinition(String topic);

    @SystemMessage("""
            You are an intelligent assistant tasked with categorizing the priority of incoming customer service tickets. Each ticket includes a customer's request or issue. Your job is to evaluate the content of the ticket and assign one of the following priorities based on the urgency and impact of the request:
            
            - HIGH: For urgent issues that require immediate attention, such as critical system failures, security issues, or any matter severely impacting operations.
            - MEDIUM: For important issues that require resolution but do not cause immediate disruption, such as feature requests or configuration issues affecting a small subset of users.
            - LOW: For non-urgent issues, minor inconveniences, or general questions about using the system.
            - UNKNOWN: If the message is unclear, does not appear to be a service request, or if you cannot determine the priority from the provided information.
            
            Return only the priority label (HIGH, MEDIUM, LOW, or UNKNOWN) and also a brief ticket summary and explanation for the chosen priority.
            Here is a customer request (below delimited by ---):
            ---
            {ticket}
            ---
            What is the priority for this ticket?
            """)
    TicketPriority reviewTicket(String ticket);

}

