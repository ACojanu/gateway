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
package org.kaazing.gateway.transport.wsn.auth;

import static org.kaazing.test.util.ITUtil.createRuleChain;

import java.net.URI;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.kaazing.gateway.server.test.GatewayRule;
import org.kaazing.gateway.server.test.config.GatewayConfiguration;
import org.kaazing.gateway.server.test.config.builder.GatewayConfigurationBuilder;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

public class AsyncBasicLoginModuleTestIT {

    private K3poRule robot = new K3poRule();

    public GatewayRule gateway = new GatewayRule() {
        {
            GatewayConfiguration configuration = new GatewayConfigurationBuilder()
                .service()
                    .accept(URI.create("ws://localhost:8001/echoAuth"))
                    .type("echo")
                    .realmName("demo")
                        .authorization()
                        .requireRole("USER")
                    .done()
                .done()
                .security()
                    .realm()
                        .name("demo")
                        .description("Kaazing WebSocket Gateway Demo")
                        .httpChallengeScheme("Basic")
                        .loginModule()
                            .type("class:org.kaazing.gateway.transport.wsn.auth.AsyncBasicLoginModule")
                            .success("requisite")
                            .option("roles", "USER")
                        .done()
                    .done()
                .done()
            .done();
            init(configuration);
        }
    };

	@Rule
	public TestRule chain = createRuleChain(gateway, robot);

	@Specification("asyncBasicLoginModuleSuccess")
	@Test
	public void asyncBasicLoginModuleSuccess() throws Exception {
		robot.finish();
	}

    @Specification("asyncBasicLoginModuleFailure")
    @Test
    public void asyncBasicLoginModuleFailure() throws Exception {
        robot.finish();
    }

}
