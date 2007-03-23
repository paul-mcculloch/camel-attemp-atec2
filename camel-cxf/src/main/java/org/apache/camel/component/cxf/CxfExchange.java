/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.cxf;

import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.CamelContext;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.Conduit;

/**
 * An {@link Exchange} for working with Apache CXF
 *
 * @version $Revision$
 */
public class CxfExchange extends DefaultExchange {
    private final CxfBinding binding;
    private Exchange exchange;

    public CxfExchange(CamelContext context, CxfBinding binding) {
        super(context);
        this.binding = binding;
    }

    public CxfExchange(CamelContext context, CxfBinding binding, Exchange exchange) {
        super(context);
        this.binding = binding;
        this.exchange = exchange;

        setIn(new CxfMessage(exchange.getInMessage()));
        setOut(new CxfMessage(exchange.getOutMessage()));
        setFault(new CxfMessage(exchange.getInFaultMessage()));
    }
    @Override
    public CxfMessage getIn() {
        return (CxfMessage) super.getIn();
    }

    @Override
    public CxfMessage getOut() {
        return (CxfMessage) super.getOut();
    }

    @Override
    public CxfMessage getFault() {
        return (CxfMessage) super.getFault();
    }

    /**
     * @return the Camel <-> JBI binding
     */
    public CxfBinding getBinding() {
        return binding;
    }

    // Expose CXF APIs directly on the exchange
    //-------------------------------------------------------------------------

    /**
     * Returns the underlying CXF message exchange for an inbound exchange
     * or null for outbound messages
     *
     * @return the inbound message exchange
     */
    public Exchange getExchange() {
        return exchange;
    }

    public Message getOutFaultMessage() {
        return getExchange().getOutFaultMessage();
    }

    public Message getInMessage() {
        return getExchange().getInMessage();
    }

    public Message getInFaultMessage() {
        return getExchange().getInFaultMessage();
    }

    public Message getOutMessage() {
        return getExchange().getOutMessage();
    }

    public Destination getDestination() {
        return getExchange().getDestination();
    }

    public Conduit getConduit() {
        return getExchange().getConduit();
    }


    @Override
    protected CxfMessage createInMessage() {
        return new CxfMessage();
    }

    @Override
    protected CxfMessage createOutMessage() {
        return new CxfMessage();
    }
}
