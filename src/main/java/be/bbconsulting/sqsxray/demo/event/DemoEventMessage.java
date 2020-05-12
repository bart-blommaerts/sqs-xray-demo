package be.bbconsulting.sqsxray.demo.event;

import be.bbconsulting.sqsxray.demo.domain.DemoEvent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

// application layer
public class DemoEventMessage {

    private DemoEvent demoEvent;

    @JsonCreator
    public DemoEventMessage(Map<String,Object> delegate) throws IOException {
        String json = (String) delegate.get("Message");
        ObjectMapper mapper = new ObjectMapper();
        this.demoEvent = mapper.readValue(json, DemoEvent.class);
    }

    public DemoEvent getDemoEvent() {
        return demoEvent;
    }
}
