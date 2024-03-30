namespace KeyValueStore
{
    internal class KVS
    {
        private Dictionary<string,KVS_Value> store;
        private Dictionary<string, Type> valueTypesForAKey;
        public KVS()
        {
            store = new Dictionary<string, KVS_Value>();
            valueTypesForAKey = new Dictionary<string, Type>();
        }

        public KVS_Value Get(string key)
        {
            if(store.ContainsKey(key))
                return store[key];
            return null;
        }

        public List<string> Search(string a_key, string a_value)
        {
            List<string> keys = new List<string>();
            foreach(var item in store)
            {
                KVS_Value val = item.Value;
                if(val.Contains(a_key, a_value))
                    keys.Add(item.Key);
            }
            return keys;
        }

        public void Put(string key, List<KeyValuePair<string,string>> listOfAttributePairs)
        {
            store[key] = new KVS_Value(listOfAttributePairs);
        }

        public void Delete(string key)
        {
            if(store.ContainsKey(key))
                store.Remove(key);
        }

        public List<string> Keys()
        {
            List<string> keys = new List<string>();
            Dictionary<string,KVS_Value>.KeyCollection keySet = store.Keys;
            foreach(var key in keySet)
                keys.Add(key);
            return keys;
        }
    }
}
