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

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;

public class AmazonEC2ClientMock extends AmazonEC2Client {   

    public AmazonEC2ClientMock() {
        super(new BasicAWSCredentials("user", "secret"));
    }
    
    
    @Override
    public DescribeInstancesResult describeInstances() throws AmazonServiceException, AmazonClientException {
        DescribeInstancesResult result = new DescribeInstancesResult();
        
        result.withReservations(new Reservation().withInstances(new Instance().withInstanceId("someinstanceid")));
        result.setNextToken("TOKEN2");
        return result;
    }



}