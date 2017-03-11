/*
 * Copyright © 2016 WIDE Project and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.dmd.cli.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opendaylight.dmd.cli.api.DmdCliCommands;

public class DmdCliCommandsImpl implements DmdCliCommands {

    private static final Logger LOG = LoggerFactory.getLogger(DmdCliCommandsImpl.class);
    private final DataBroker dataBroker;

    public DmdCliCommandsImpl(final DataBroker db) {
        this.dataBroker = db;
        LOG.info("DmdCliCommandImpl initialized");
    }

    @Override
    public Object testCommand(Object testArgument) {
        return "This is a test implementation of test-command";
    }
}