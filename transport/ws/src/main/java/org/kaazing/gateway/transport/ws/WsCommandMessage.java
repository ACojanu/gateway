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
package org.kaazing.gateway.transport.ws;


public class WsCommandMessage extends WsMessage {
    // TODO: fix WsMessage inheritance hierarchy so WsCommandMessage doesn't have getBytes method

    public static final WsMessage NOOP = new WsCommandMessage(Command.noop());
    public static final WsMessage RECONNECT = new WsCommandMessage(Command.reconnect());
    public static final WsMessage CLOSE = new WsCommandMessage(Command.close());

    private final Command[] commands;

    public WsCommandMessage(Command... commands) {
        if (commands == null) {
            throw new NullPointerException("commands");
        }
        this.commands = commands;
    }

    public Command[] getCommands() {
        return commands;
    }

    @Override
    public Kind getKind() {
        return Kind.COMMAND;
    }

}
