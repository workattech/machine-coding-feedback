namespace KeyValueStore
{
    internal class KVS_Value: Object
    {
        public Dictionary<string,string> attributePairs {get;set;}

        public KVS_Value(List<KeyValuePair<string,string>> ListOfAttributePairs)
        {
            attributePairs = new Dictionary<string, string> (ListOfAttributePairs);
        }

        public bool Contains(string key, string value)
        {
            return attributePairs.ContainsKey(key) && attributePairs[key] == value;
        }
        public override string ToString()
        {
            string result = "";
            foreach(var pair in attributePairs)
            {
                if(result != "") result = result + ", ";
                result = result + $"{pair.Key}: {pair.Value}";
            }
            return result;
        }
    }
}