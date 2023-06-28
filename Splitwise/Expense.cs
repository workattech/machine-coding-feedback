public class Expense
{
    public string ExpenseId { get; set; }
    public SplitType SplitType { get; set; }
    public User Payer { get; set; }
    public List<User> Payees { get; set; }
    public int Amount { get; set; }

    public void RecordTransaction(User Payer,User Payee,int amount)
    {
        Payer.Owes[Payee.Id] = ((-1) * amount) + Payer.Owes[Payee.Id];
        Payee.Owes[Payer.Id] = amount + Payee.Owes[Payer.Id]; 
    }

    public void SplitAmount()
    {
        switch(SplitType)
        {
            case SplitType.EQUAL:
                int split = Amount/Payees.Count; 
                foreach(User payee in Payees)
                {
                    RecordTransaction(Payer,payee,split);
                }
                break;

            case SplitType.EXACT:
            
                break;

            


        }

    }






}