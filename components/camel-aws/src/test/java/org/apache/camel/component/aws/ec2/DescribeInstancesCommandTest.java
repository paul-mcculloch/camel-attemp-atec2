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

import static org.junit.Assert.assertEquals;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Before;
import org.junit.Test;

public class DescribeInstancesCommandTest {

    private DescribeInstancesCommand command;
    private AmazonEC2ClientMock ec2Client;
    private EC2Configuration configuration;
    private Exchange exchange;
    
    @Before
    public void setUp() {
        ec2Client = new AmazonEC2ClientMock();
        configuration = new EC2Configuration();
        exchange = new DefaultExchange(new DefaultCamelContext());
        
        command = new DescribeInstancesCommand(ec2Client, configuration, exchange);
    }

    @Test
    public void execute() {
        exchange.getIn().setHeader(EC2Constants.NEXT_TOKEN, "TOKEN1");
        
        command.execute();

        DescribeInstancesResult results = exchange.getIn().getHeader(EC2Constants.DESCRIBE_INSTANCES_RESULTS, DescribeInstancesResult.class);
        assertEquals("TOKEN2", exchange.getIn().getHeader(EC2Constants.NEXT_TOKEN));
        assertEquals("someinstanceid", results.getReservations().get(0).getInstances().get(0).getInstanceId());
    }

}