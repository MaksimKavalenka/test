package org.learning.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPreUpdateEventListenerImpl;
import org.hibernate.event.spi.PreUpdateEvent;

@Slf4j
public class MyEnversPreUpdateEventListenerImpl extends EnversPreUpdateEventListenerImpl {

    public MyEnversPreUpdateEventListenerImpl(EnversService enversService) {
        super(enversService);
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        if (event.getEntity() instanceof Book && ((Book) event.getEntity()).getCity().equals("save")) {
            log.debug("Book");
            return true;
        }

        if (event.getEntity() instanceof Address && ((Address) event.getEntity()).getCity().equals("save")) {
            log.debug("Address");
            return true;
        }

        return super.onPreUpdate(event);
    }

}
