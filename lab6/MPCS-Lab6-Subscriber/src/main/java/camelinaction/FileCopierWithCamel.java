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
package camelinaction;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;

public class FileCopierWithCamel {

    public static void main(String args[]) throws Exception {
        // create CamelContext
        CamelContext context = new DefaultCamelContext();

        // connect to ActiveMQ JMS broker listening on localhost on port 61616
        ConnectionFactory connectionFactory = 
        	new ActiveMQConnectionFactory("tcp://localhost:61616");
        context.addComponent("jms",
            JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
            	 from("jms:topic:MPCS_51050_LAB6_TOPIC_IBM").log("SUBSCRIBER RECEIVED: jms IBM queue: ${body} from file: ${header.CamelFileNameOnly}")
            	 .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                    	
                    	String[] array = exchange.getIn().getBody(String.class).split("\t");
                    	
                    	StringBuilder str = new StringBuilder();
                    	str.append("Stock: ");
                    	str.append(array[0].substring(1));
                    	str.append("|BidPrice: ");
                    	str.append(array[1]);
                    	str.append("|BidQuantity: ");
                    	str.append(array[2]);
                    	str.append("|AskPrice: ");
                    	str.append(array[3]);
                    	str.append("|AskQuantity: ");
                    	str.append(array[4]);
                    	System.out.println(str.toString());
                    	exchange.getIn().setBody(str.toString());
                    	
                    	
        } }).to("jms:queue:MPCS_51050_LAB6_ALL");
            	 
            	 
            	 from("jms:topic:MPCS_51050_LAB6_TOPIC_MSFT").log("SUBSCRIBER RECEIVED: jms FSFT queue: ${body} from file: ${header.CamelFileNameOnly}")
            	 .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                    	
                    	String[] array = exchange.getIn().getBody(String.class).split("\t");
                    	
                    	StringBuilder str = new StringBuilder();
                    	str.append("Stock: ");
                    	str.append(array[0].substring(1));
                    	str.append("|BidPrice: ");
                    	str.append(array[1]);
                    	str.append("|BidQuantity: ");
                    	str.append(array[2]);
                    	str.append("|AskPrice: ");
                    	str.append(array[3]);
                    	str.append("|AskQuantity: ");
                    	str.append(array[4]);
                    	System.out.println(str.toString());
                    	exchange.getIn().setBody(str.toString());
                    	
                    	
        } }).to("jms:queue:MPCS_51050_LAB6_ALL");
            	 
            	 
            	 from("jms:topic:MPCS_51050_LAB6_TOPIC_ORCL").log("SUBSCRIBER RECEIVED: jms ORCL queue: ${body} from file: ${header.CamelFileNameOnly}")
            	 .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                    	
                    	String[] array = exchange.getIn().getBody(String.class).split("\t");
                    	
                    	StringBuilder str = new StringBuilder();
                    	str.append("Stock: ");
                    	str.append(array[0].substring(1));
                    	str.append("|BidPrice: ");
                    	str.append(array[1]);
                    	str.append("|BidQuantity: ");
                    	str.append(array[2]);
                    	str.append("|AskPrice: ");
                    	str.append(array[3]);
                    	str.append("|AskQuantity: ");
                    	str.append(array[4]);
                    	System.out.println(str.toString());
                    	exchange.getIn().setBody(str.toString());
                    	
                    	
        } }).to("jms:queue:MPCS_51050_LAB6_ALL");
                
                try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

     
            }
        });

        // start the route and let it do its work
        context.start();
        Thread.sleep(16000);

        // stop the CamelContext
        context.stop();
    }
}
