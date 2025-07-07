package domainevent.command.handler;

import msa.commons.event.EventData;

public interface EventHandler {
    void handleCommand(String json);
}
