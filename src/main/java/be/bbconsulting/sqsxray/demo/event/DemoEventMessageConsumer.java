package be.bbconsulting.sqsxray.demo.event;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.jashmore.sqs.argument.payload.Payload;
import com.jashmore.sqs.spring.container.basic.QueueListener;
import org.springframework.stereotype.Component;

@XRayEnabled
@Component
public class DemoEventMessageConsumer {

    private final DemoEventHandler eventHandler;

    public DemoEventMessageConsumer(DemoEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @QueueListener("${sqs.queue.name}")
    public void processEvent(@Payload DemoEventMessage demoEventMessage) {
        eventHandler.processEvent(demoEventMessage);
    }
}
