namespace PubSub
{
    public class Consumer
    {        
        public string Name;
        
        public DQ dq;

        public Consumer(string name, DQ dq)
        {
            this.Name = name;
            this.dq = dq;
        }

        public void subscribeToTopic(string topicName)
        {
            dq.addSubscriber(topicName, this);
        }

        public void getNotified(Message item)
        {
            string timestamp = item.dateTime.ToString("yyyy-MM-dd HH:mm:ss.ffff");
            Console.WriteLine($"{timestamp} {Name} Received information on {item.topicName}\t{item.message}");
        }
    }
}