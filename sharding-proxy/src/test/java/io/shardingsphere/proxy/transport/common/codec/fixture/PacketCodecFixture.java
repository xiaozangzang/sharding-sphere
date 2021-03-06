/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.proxy.transport.common.codec.fixture;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.shardingsphere.proxy.transport.common.codec.PacketCodec;
import io.shardingsphere.proxy.transport.common.packet.DatabasePacket;

import java.util.List;

public final class PacketCodecFixture extends PacketCodec<DatabasePacket> {
    
    @Override
    protected boolean isValidHeader(final int readableBytes) {
        return readableBytes > 0;
    }
    
    @Override
    protected void doDecode(final ChannelHandlerContext context, final ByteBuf in, final List<Object> out, final int readableBytes) {
        context.read();
    }
    
    @Override
    protected void doEncode(final ChannelHandlerContext context, final DatabasePacket message, final ByteBuf out) {
        context.write(message);
    }
}
