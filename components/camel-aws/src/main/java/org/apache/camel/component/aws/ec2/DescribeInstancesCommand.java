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

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import org.apache.camel.Exchange;
import org.apache.camel.Message;

public class DescribeInstancesCommand extends AbstractEC2Command {

    public DescribeInstancesCommand(AmazonEC2Client amazonEC2Client, EC2Configuration configuration, Exchange exchange) {
        super(amazonEC2Client, configuration, exchange);
    }

    public void execute() {
    
        log.trace("Sending request [{}] for exchange [{}]...", exchange);
        
        DescribeInstancesResult result = this.ec2Client.describeInstances();
        
        Message msg = getMessageForResponse(exchange);
        
        msg.setHeader(EC2Constants.NEXT_TOKEN, result.getNextToken());
        msg.setHeader(EC2Constants.RESERVATIONS, result.getReservations());

    }

}