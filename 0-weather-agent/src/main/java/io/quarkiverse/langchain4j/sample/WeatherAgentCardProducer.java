package io.quarkiverse.langchain4j.sample;

import io.a2a.server.PublicAgentCard;
import io.a2a.spec.AgentCapabilities;
import io.a2a.spec.AgentCard;
import io.a2a.spec.AgentSkill;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Collections;
import java.util.List;

/**
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
@ApplicationScoped
public class WeatherAgentCardProducer {

    /** The HTTP port for the agent service. */
    @Inject
    @ConfigProperty(name = "quarkus.http.port")
    private int httpPort;

    /**
     * Gets the HTTP port.
     *
     * @return the HTTP port
     */
    public int getHttpPort() {
        return httpPort;
    }

    /**
     * Produces the agent card for the weather agent.
     *
     * @return the configured agent card
     */
    @Produces
    @PublicAgentCard
    public AgentCard agentCard() {
        return new AgentCard.Builder()
                .name("Weather Agent")
                .description("Helps with weather in the USA")
                .url("http://localhost:" + getHttpPort())
                .version("1.0.0")
                .capabilities(
                        new AgentCapabilities.Builder()
                                .streaming(true)
                                .pushNotifications(false)
                                .stateTransitionHistory(false)
                                .build())
                .defaultInputModes(Collections.singletonList("text"))
                .defaultOutputModes(Collections.singletonList("text"))
                .skills(
                        Collections.singletonList(
                                new AgentSkill.Builder()
                                        .id("weather_search")
                                        .name("Search weather")
                                        .description("Helps with weather in city, or states in the USA")
                                        .tags(Collections.singletonList("weather"))
                                        .examples(List.of("weather in LA, CA"))
                                        .build()))
                .protocolVersion("0.3.0")
                .build();
    }
}
