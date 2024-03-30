namespace PubSub
{
    public class Topic
    {
        public string Name;

        public List<Consumer> subscribers;

        public Topic(string name)
        {
            Name = name;
            subscribers = new List<Consumer>();
        }
        public void addSubscriber(Consumer consumer)
        {
            subscribers.Add(consumer);
        }        
    }
}