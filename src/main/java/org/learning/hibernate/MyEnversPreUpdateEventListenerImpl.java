package org.learning.hibernate;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPreUpdateEventListenerImpl;
import org.hibernate.event.spi.PreUpdateEvent;

public class MyEnversPreUpdateEventListenerImpl extends EnversPreUpdateEventListenerImpl {

    public MyEnversPreUpdateEventListenerImpl(EnversService enversService) {
        super(enversService);
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        if (event.getEntity() instanceof Book && ((Book) event.getEntity()).getCity().equals("save")) {
            return true;
        }

        return super.onPreUpdate(event);
    }

}
