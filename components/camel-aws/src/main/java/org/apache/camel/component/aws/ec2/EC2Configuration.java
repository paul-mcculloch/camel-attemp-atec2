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

/**
 * The AWS EC2 component configuration properties
 * 
 */
public class EC2Configuration {
    private String accessKey;
    private String secretKey;
    private AmazonEC2Client amazonEC2Client;
    private String amazonEC2Endpoint;
    private EC2Operations operation;
  
    public String getAccessKey() {
        return accessKey;
    }
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
    public String getSecretKey() {
        return secretKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    public AmazonEC2Client getAmazonEC2Client() {
        return amazonEC2Client;
    }
    public void setAmazonEC2Client(AmazonEC2Client amazonEC2Client) {
        this.amazonEC2Client = amazonEC2Client;
    }
    public String getAmazonEC2Endpoint() {
        return amazonEC2Endpoint;
    }
    public void setAmazonEC2Endpoint(String amazonEC2Endpoint) {
        this.amazonEC2Endpoint = amazonEC2Endpoint;
    }
    public EC2Operations getOperation() {
        return operation;
    }
    public void setOperation(EC2Operations operation) {
        this.operation = operation;
    }

}
