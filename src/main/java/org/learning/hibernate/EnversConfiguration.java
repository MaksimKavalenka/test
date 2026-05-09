package org.learning.hibernate;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class EnversConfiguration {

    @Bean
    public EventListenerRegistry listenerRegistry(EntityManagerFactory entityManagerFactory) {
        ServiceRegistryImplementor serviceRegistry = entityManagerFactory.unwrap(SessionFactoryImpl.class).getServiceRegistry();

        final EnversService enversService = serviceRegistry.getService(EnversService.class);
        EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);

        listenerRegistry.setListeners(EventType.PRE_UPDATE, new MyEnversPreUpdateEventListenerImpl(enversService));
        return listenerRegistry;
    }

}
