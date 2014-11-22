/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.aws.ec2;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.apache.camel.util.URISupport;

/**
 * A Producer which sends messages to the Amazon EC2 Service
 */
public class EC2Producer extends DefaultProducer {
    
    public EC2Producer(Endpoint endpoint) {
        super(endpoint);
    }

    public void process(Exchange exchange) throws Exception {
        switch (determineOperation(exchange)) {
        case DescribeInstances:
            new DescribeInstancesCommand(getEndpoint().getEC2Client(), getConfiguration(), exchange).execute();
            break;
        default:
            throw new IllegalArgumentException("Unsupported operation");
        }
    }

    private EC2Operations determineOperation(Exchange exchange) {
        EC2Operations operation = exchange.getIn().getHeader(EC2Constants.OPERATION, EC2Operations.class);
        if (operation == null) {
            operation = getConfiguration().getOperation();
        }
        return operation;
    }

    protected EC2Configuration getConfiguration() {
        return getEndpoint().getConfiguration();
    }

    @Override
    public String toString() {
        return "EC2Producer[" + URISupport.sanitizeUri(getEndpoint().getEndpointUri()) + "]";
    }

    @Override
    public EC2Endpoint getEndpoint() {
        return (EC2Endpoint) super.getEndpoint();
    }
}