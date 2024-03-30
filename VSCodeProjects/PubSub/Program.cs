namespace PubSub;

class Program
{
    static int count = 0;
    static void Main(string[] args)
    {
        //Console.WriteLine("Hello, World!");
        DQ dq = new DQ();

        List<Producer> producers = new List<Producer>
        {
            new Producer("Producer1", dq),
            new Producer("Producer2", dq)
        };

        List<Consumer> consumers = new List<Consumer>
        {
            new Consumer("Consumer1", dq),
            new Consumer("Consumer2", dq),
            new Consumer("Consumer3", dq),
            new Consumer("Consumer4", dq),
            new Consumer("Consumer5", dq),
        };
        
        Topic t1 = new Topic("Topic1");
        Topic t2 = new Topic("Topic2");
        Topic t3 = new Topic("Topic3");

        //subscribe consumers to topics
        dq.addSubscriberList("Topic1", consumers);
        dq.addSubscriberList("Topic2", new List<Consumer>(){
            consumers[0],consumers[2],consumers[3]
            });
        dq.addSubscriberList("Topic3", new List<Consumer>(){
            consumers[4]
            });

        startMultiThreading(producers);
    }

    static void startMultiThreading(List<Producer> producers)
    {
        List<Thread> threads = new List<Thread>();
        const int runTimeInSeconds = 1;

        //Create new thread for each producer to produce items
        foreach (var producer in producers)
        {
            Thread thread = new Thread(() =>
            {
                DateTime endTime = DateTime.Now.AddSeconds(runTimeInSeconds);
                while (DateTime.Now < endTime)
                {
                    eachThreadJob(producer);
                    Thread.Sleep(50); // Sleep for 1 second before producing next item
                }
            });

            thread.Start();
            threads.Add(thread);
        }

        // Wait for all threads to finish
        foreach (var thread in threads)
        {
            thread.Join();
        }
    }

    static void eachThreadJob(Producer p)
    {
        string topic = getRandomTopicForProducer(p);
        p.Produce(topic, getMessage());
    }

    static string getRandomTopicForProducer(Producer p)
    {
        List<string> topics = getEligibleTopicList(p.Name);
        Random random = new Random();
        // Generate a random index
        int randomIndex = random.Next(0, topics.Count); 
        // Get the item at the random index
        return topics[randomIndex];
    }

    static List<string> getEligibleTopicList(string producerName)
    {
        if(producerName == "Producer1")
            return new List<string>(){"Topic1", "Topic2"};
        //if(producerName == "Producer2")
            return new List<string>(){"Topic1", "Topic2","Topic3"};
    }

    static string getMessage()
    {
        return "This is message "+(++count);
    }
}
