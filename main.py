from models.User import User
from services.Expense import Expense

if __name__ == "__main__":
    user1 = User("u1", "suraj", "", "")
    user2 = User("u2", "siddharth", "", "")
    user3 = User("u3", "ganesh", "", "")
    user4 = User("u4", "mukesh", "", "")
    user_dict = {user1.id: user1, user2.id: user2, user3.id: user3, user4.id: user4}
    users = [user1, user2, user3, user4]
    expense = Expense()
    with open('input.txt', 'r') as file:
        input_lines = file.readlines()
        for line in input_lines:
            words = line.split()
            command = words[0].lower()

            if command == 'show':
                if len(words) == 1:
                    expense.show_all(users)
                else:
                    user_id = words[1]
                    user = user_dict[user_id]
                    expense.show_all([user])
            elif command == 'expense':
                payee = words[1]
                amount = float(words[2])
                num_users = int(words[3])
                users = words[4:4+num_users]
                users = [user_dict[user_id] for user_id in users]
                split_type = words[4+num_users].lower()
                if split_type == 'equal':
                    expense.equal_split(user_dict[payee], amount, users)
                elif split_type == 'exact':
                    split_values = list(map(float, words[5+num_users:]))
                    expense.exact_split(user_dict[payee], amount, users, split_values)
                elif split_type == 'percent':
                    split_values = list(map(float, words[5+num_users:]))
                    expense.percent_split(user_dict[payee], amount, users, split_values)

    # expense.equal_split(user1, 100, [user1, user2, user3, user4])
    # expense.exact_split(user1, 1250, [user2, user3], [370, 880])
    # expense.percent_split(user4, 1200, [user1, user2, user3, user4], [40, 20, 20, 20])
