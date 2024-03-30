namespace KeyValueStore;

class Program
{
    static void Main(string[] args)
    {
        string inputFile = "./Data/input.txt";

        string[] lines = File.ReadAllLines(inputFile);

        KVS kvs = new KVS();
        foreach(var line in lines)
        {
            ProcessInput(line, kvs);
        }
        Console.WriteLine("Hello, World!");
    }

    static void ProcessInput(string input, KVS kvs)
    {
        string[] tokens = input.Split(" ");
        switch(tokens[0])
        {
            case "put":
            {
                List<KeyValuePair<string,string>> attributes = new List<KeyValuePair<string,string>>();
                for(int index = 2; index<tokens.Length-1; index += 2)
                {
                    attributes.Add(new KeyValuePair<string,string> (tokens[index], tokens[index+1]));
                }
                kvs.Put(tokens[1], attributes);
                break;
            }
            case "get":
            {
                KVS_Value kvs_Value = kvs.Get(tokens[1]);
                if(kvs_Value != null)
                    Console.WriteLine(kvs_Value.ToString());
                else
                    Console.WriteLine($"No entry found for {tokens[1]}");
                break;
            }
            case "keys":
            {
                List<string> keys = kvs.Keys();
                foreach(var key in keys)
                {
                    Console.Write(key + ", ");
                }
                Console.WriteLine();
                break;
            }
            case "search":
            {
                List<string> keys = kvs.Search(tokens[1], tokens[2]);
                foreach(string key in keys)
                {
                    Console.Write(key + ", ");
                }
                Console.WriteLine();
                break;
            }
            case "delete":
            {
                kvs.Delete(tokens[1]);
                break;
            }
            default:
                break;
        }

    }
}
