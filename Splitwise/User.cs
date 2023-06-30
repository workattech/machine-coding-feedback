public class User
{
    public string Id { get; set; }
    public string Name { get; set; } = string.Empty;
    public string Mobile { get; set; } = string.Empty;
    public string Email { get; set; } = string.Empty;

    public User(string id,string name)
    {
        Id = id;
        Name = name ;
    }

}