package dev.stiebo;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api")
public class AiController {

    @Inject
    AiServiceM1 aiServiceM1;

    @Inject
    AiServiceM2 aiServiceM2;

    @Path("joke")
    @GET
    public String getJoke() {
        return aiServiceM1.getJoke();
    }

    @Path("poem")
    @GET
    public Poem poem() {
        return aiServiceM1.writeAPoem("snow", 4);
    }

    @Path("wikipedia")
    @GET
    public TermDefinition wikipedia() {
        return aiServiceM1.writeDefinition("snow");
    }

    @Path("flashcards")
    @GET
    public Flashcards flashcards() {
        return aiServiceM2.createFlashcards("""
                Snow comprises individual ice crystals that grow while suspended in the atmosphere—usually within clouds—and then fall, accumulating on the ground where they undergo further changes.[2] It consists of frozen crystalline water throughout its life cycle, starting when, under suitable conditions, the ice crystals form in the atmosphere, increase to millimeter size, precipitate and accumulate on surfaces, then metamorphose in place, and ultimately melt, slide or sublimate away.
                
                Snowstorms organize and develop by feeding on sources of atmospheric moisture and cold air. Snowflakes nucleate around particles in the atmosphere by attracting supercooled water droplets, which freeze in hexagonal-shaped crystals. Snowflakes take on a variety of shapes, basic among these are platelets, needles, columns and rime. As snow accumulates into a snowpack, it may blow into drifts. Over time, accumulated snow metamorphoses, by sintering, sublimation and freeze-thaw. Where the climate is cold enough for year-to-year accumulation, a glacier may form. Otherwise, snow typically melts seasonally, causing runoff into streams and rivers and recharging groundwater.
                
                Major snow-prone areas include the polar regions, the northernmost half of the Northern Hemisphere and mountainous regions worldwide with sufficient moisture and cold temperatures. In the Southern Hemisphere, snow is confined primarily to mountainous areas, apart from Antarctica.[3]
                
                Snow affects such human activities as transportation: creating the need for keeping roadways, wings, and windows clear; agriculture: providing water to crops and safeguarding livestock; sports such as skiing, snowboarding, and snowmachine travel; and warfare. Snow affects ecosystems, as well, by providing an insulating layer during winter under which plants and animals are able to survive the cold.
                """);
    }

    @Path("ticket-priority")
    @GET
    public TicketPriority prioritizeTicket() {
        return aiServiceM2.reviewTicket("""
                MS Word is not working. I am a carpenter
                """);
    }
}
