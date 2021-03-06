/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.gateway.resource.address.rtmp;

import static org.kaazing.gateway.resource.address.ResourceFactories.keepAuthorityOnly;

import org.kaazing.gateway.resource.address.ResourceFactory;
public class RtmpsResourceAddressFactorySpi extends RtmpResourceAddressFactorySpi {

    private static final String SCHEME_NAME = "rtmps";
    private static final int SCHEME_PORT = -1;
    private static final ResourceFactory TRANSPORT_FACTORY = keepAuthorityOnly("ssl");

    @Override
    public String getSchemeName() {
        return SCHEME_NAME;
    }

    @Override
    protected int getSchemePort() {
        return SCHEME_PORT;
    }

    @Override
    protected ResourceFactory getTransportFactory() {
        return TRANSPORT_FACTORY;
    }

}
