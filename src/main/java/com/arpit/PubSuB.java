package com.arpit;


import java.util.*;

/**
 * Design an in-memory message queue which has the following capabilities
 * - It should support multiple topics where messages can be published.
 * - Publisher should be able to publish a message to a particular topic.
 * - Subscribers should be able to subscribe to a topic.
 * - Whenever a message is published to a topic, all the subscribers,
 * who are subscribed to that topic, should receive the message.
 * - should be thread safe and allow fast concurrent operations
 * ----------------------------------------------------------------
 * Task :
 * assume we have
 * <p>
 * --
 * 1. Data structure to Hold the data
 * 1.1. If we need to persist
 * Similar to Kafka : Maintain the offset per cosumer/
 * consumer group and delet the data at some period
 * <p>
 * 1.2 I
 * 2.
 */

interface Pub {
    // return true if data is published
    public boolean publish(String topic, String data);
}

interface Sub {
    // return data if data is published
    public String poll(String topic);
}


public class PubSuB {

    int capacity = 10;
    Map<String, Queue<String>> map = new HashMap<>();
    {
        map.put("Topic1",new LinkedList<>());
    }


    public static void main(String[] args) {
        PubSuB pubSuB = new PubSuB();
        pubSuB.startPublishers("Topic1");
        pubSuB.startConsumers("Topic1");

    }

    private void startPublishers(String topic) {
        Publisher p1 = new Publisher(map.get(topic));
        //Publisher p2 = new Publisher(map.get(topic));

        Thread t = new Thread(p1);
        t.start();
        /*t = new Thread(p2);
        t.start();*/
    }
    private void startConsumers(String topic) {
        Consumer c1 = new Consumer("C1");
        Consumer c2 = new Consumer("C2");
        ConsumerHelper ch = new ConsumerHelper(map.get(topic));
        ch.addConsumer(c1);
        ch.addConsumer(c2);
        Thread t = new Thread(ch);
        t.start();
    }
}

class Publisher implements Runnable {
    Queue<String> queue;

    Publisher(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String message = "String" + i;
            System.out.println(Thread.currentThread().getName() + " Publishing Message :" + message);

            queue.add(message);
        }
    }
}

class ConsumerHelper implements Runnable{
    List<Consumer> consumers = new ArrayList<>();
    Queue<String> queue;

    ConsumerHelper(Queue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String message = queue.poll();
            consumers.forEach( c -> c.processMessage( message));
        }
    }

    public void addConsumer(Consumer c){
        consumers.add(c);
    }



}
class Consumer {

    String name;

    Consumer(String name){
        this.name = name;
    }
   public void processMessage(String message) {
       System.out.println(name + "Processing the message"+message);
    }
}
