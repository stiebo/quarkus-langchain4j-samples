package dev.stiebo;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(modelName="m2")
public interface AiServiceM2 {
    @SystemMessage("""
            I am providing you with learning content on a specific topic below delimited by ---. Your task is to generate a comprehensive set of questions
            paired with correct answers to help a student learn and practice the entire content provided.
            
            Requirements:
            Source Content Overview:
            The content may cover topics from various academic or educational subjects and could be from a document, textbook,
            image, or digital content.
            
            Question-Answer Pairs:
            Create questions with corresponding correct answers that thoroughly cover the content provided. No part of the content
            should be left unaddressed by a question. Ensure answers are concise and complete, but as short as possible and avoid
            any unnecessary or lengthy text. Do not repeat parts of the question in the answers. Focus the answers on key facts and
            concepts relevant to the question while omitting any redundant details. Avoid requiring the student to refer back to the
            document; questions should promote recall and understanding. Questions and answers should be in the same language as the
            content provided.
            
            Question Variety and Difficulty:
            Include questions of varying difficulty, from basic comprehension to critical thinking or application.
            The questions should be suitable for the student level indicated by the material, covering all main ideas and details
            of the content.
            
            Correctness and Learning Focus:
            Verify all answers for accuracy and ensure questions help students retain the content effectively.
            The questions should facilitate active recall and deepen the student’s understanding.
            """)
    @UserMessage("""
            ---
            {text}
            ---
            """)
    Flashcards createFlashcards(String text);

    @SystemMessage("""
            You are an intelligent assistant tasked with categorizing the priority of incoming customer service tickets. Each ticket includes a customer's request or issue. Your job is to evaluate the content of the ticket and assign one of the following priorities based on the urgency and impact of the request:
            
            - HIGH: For urgent issues that require immediate attention, such as critical system failures, security issues, or any matter severely impacting operations.
            - MEDIUM: For important issues that require resolution but do not cause immediate disruption, such as feature requests or configuration issues affecting a small subset of users.
            - LOW: For non-urgent issues, minor inconveniences, or general questions about using the system.
            - UNRELATED: If the message is not a service request, or if you cannot determine the priority from the provided information.
           
            Here is a customer request (below delimited by ---):
            ---
            {ticket}
            ---
            What is the priority for this ticket?
            """)
    TicketPriority reviewTicket(String ticket);
}
