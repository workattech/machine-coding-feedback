public class User
{
    public string Id { get; set; }
    public string Name { get; set; } = string.Empty;
    public string Mobile { get; set; } = string.Empty;
    public string Email { get; set; } = string.Empty;
    public Dictionary<string,int> Owes = new Dictionary<string, int>();

    public void RecordExpense(Expense expense)
    {
        throw new NotImplementedException();
    }

    public void ShowBalance()
    {
        foreach(var (key,value) in Owes)
        {
            if(key == Id)
            {
                continue;
            }
            if(value > 0)
            {
                Console.WriteLine($"{Name} owes {key} : {value} ");
            }
            if(value < 0)
            {
                Console.WriteLine($"{key} owes {Name} : {value} ");
            }
        }
    }






}