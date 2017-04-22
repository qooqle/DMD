/*
 * Copyright © 2016 WIDE Project and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.dmd.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dmd.rev150105.DmdService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DmdProvider implements BindingAwareProvider, AutoCloseable{

    private static final Logger LOG = LoggerFactory.getLogger(DmdProvider.class);

    private final DataBroker dataBroker;
    private RpcRegistration<DmdService> dmdService;    

    public DmdProvider(final DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("DmdProvider Session Initiated");
    }

    @Override
    public void onSessionInitiated(ProviderContext session) {
        LOG.info("HelloProvider Session Initiated");
        dmdService = session.addRpcImplementation(DmdService.class, new DmdServiceImpl());
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    @Override
    public void close() throws Exception {
        LOG.info("DmdProvider Closed");
        if (dmdService != null) {
            dmdService.close();
        }
    }
}
