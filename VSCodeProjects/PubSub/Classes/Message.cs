namespace PubSub
{
    public class Message
    {
        public Topic topic;

        public string topicName;

        public string message;

        public DateTime dateTime;

        public Message(string topicName, string msg)
        {
            this.topicName = topicName;
            message = msg;
            dateTime = DateTime.Now;
        }         
    }
}