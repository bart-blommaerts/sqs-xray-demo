package be.bbconsulting.sqsxray.demo.event;

import be.bbconsulting.sqsxray.demo.domain.DemoEvent;
import com.amazonaws.xray.spring.aop.XRayEnabled;
import org.springframework.stereotype.Component;

@XRayEnabled
@Component
public class DemoEventHandler {

    protected void processEvent(DemoEventMessage event) {
        // something useful with the event message

        DemoEvent demoEvent = event.getDemoEvent();
        System.out.println(demoEvent.toString());
    }
}
