package dev.stiebo;

import dev.langchain4j.model.output.structured.Description;

public record TicketPriority(
        @Description("The selected priority of the ticket")
        Priority priority,
        @Description("A brief ticket summary and explanation for the chosen priority")
        String ticketSummary
) {
}
