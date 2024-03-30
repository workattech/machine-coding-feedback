namespace PubSub
{
    public class Producer
    {
        public string Name;

        DQ dq;

        public Producer(string Name, DQ dq)
        {
            this.Name = Name;
            this.dq = dq;
        }

        public void Produce(string topicName, string message)
        {
            //string time = 
            Console.WriteLine($"{Name} producing {message} on {topicName} at {DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss.ffff")}");
            dq.pushItem(new Message(topicName,message));
            Console.WriteLine($"{Name} Produced {message} at {DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss.ffff")}");
        }        
    }
}