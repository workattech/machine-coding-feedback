namespace PubSub
{
    public class DQ
    {
        private Queue<Message> dq;

        private Dictionary<string,HashSet<Consumer>> subscriberList;

        private Dictionary<string, Topic> topicMapping;

        public DQ()
        {
            dq = new Queue<Message>();
            subscriberList = new Dictionary<string, HashSet<Consumer>>();
            topicMapping = new Dictionary<string, Topic> ();
        }

        public void pushItem(Message msg)
        {
            dq.Enqueue(msg);
            string topicName = msg.topicName;
            Thread thread = new Thread(() =>
            {
                notifyConsumersOfATopic(topicName, msg);
            });
            thread.Start();
        }

        private void notifyConsumersOfATopic(string topicName, Message msg)
        {
            string timestamp = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss.ffff");
            Console.WriteLine($"Notifying started at {timestamp}");
            HashSet<Consumer> consumers = subscriberList[topicName];
            foreach(Consumer consumer in consumers)
            {
                consumer.getNotified(msg);
            }
        }

        public void addSubscriber(string topicName, Consumer c)
        {
            if (subscriberList.ContainsKey(topicName))
            {
                subscriberList[topicName].Add(c);
            }
            else
            {
                subscriberList[topicName] = new HashSet<Consumer>{c};
            }            
        }

        public void addSubscriberList(string topicName, List<Consumer> consumers)
        {
            if (subscriberList.ContainsKey(topicName))
            {
                //subscriberList[topicName].AddRange(consumers);
            }
            else
            {
                subscriberList[topicName] = new HashSet<Consumer>(consumers);
            }
        }
    }
}