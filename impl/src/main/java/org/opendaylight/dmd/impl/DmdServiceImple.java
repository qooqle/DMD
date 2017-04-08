/*
 * Copyright © 2016 WIDE Project and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.dmd.impl;
import java.util.concurrent.Future;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dmd.rev150105.DmdService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dmd.rev150105.DmdTestApiInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dmd.rev150105.DmdTestApiInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dmd.rev150105.DmdTestApiOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dmd.rev150105.DmdTestApiOutputBuilder;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
public class DmdServiceImple implements DmdService {
    @Override
    public Future<RpcResult<DmdTestApiOutput>> dmdTestApi(DmdTestApiInput input) {
        DmdTestApiOutputBuilder dmdBuilder = new DmdTestApiOutputBuilder();
        dmdBuilder.setInputValiable("Dmd " + input.getInputValiable());
        return RpcResultBuilder.success(dmdBuilder.build()).buildFuture();
    }
}