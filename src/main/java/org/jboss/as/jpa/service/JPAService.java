/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.jpa.service;

import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceController;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.ServiceTarget;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;

/**
 * represents the global JPA Service
 *
 * @author Scott Marlow
 */
public class JPAService implements Service<Void> {

    public static final ServiceName SERVICE_NAME = ServiceName.JBOSS.append("jpa");

    private static String defaultDataSourceName = null;


    public static String getDefaultDataSourceName() {
        return defaultDataSourceName;
    }

    public static void addService(final ServiceTarget target, final String defaultDataSourceName) {
        JPAService jpaService = new JPAService();
        JPAService.defaultDataSourceName = defaultDataSourceName;
        target.addService(SERVICE_NAME, jpaService)
                .setInitialMode(ServiceController.Mode.ACTIVE)
                .install();
    }

    @Override
    public void start(StartContext startContext) throws StartException {

    }

    @Override
    public void stop(StopContext stopContext) {

    }

    @Override
    public Void getValue() throws IllegalStateException, IllegalArgumentException {
        return null;
    }

    public void setDefaultDataSourceName(String dataSourceName) {
        defaultDataSourceName = dataSourceName;
    }
}
