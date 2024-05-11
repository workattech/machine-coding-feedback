class Expense:

    def equal_split(self, payee, amount, users):
        print("equal split called")
        split_amount = round(amount / len(users), 2)
        for user in users:
            if payee.id == user.id:
                for other_user in users:
                    if other_user != user:
                        other_user.moneybook[user.id] -= split_amount
        for user in users:
            if payee.id != user.id:
                payee.moneybook[user.id] += split_amount
        # handle the case when amount is not divisible by number of users
        print("splitting done")

    def exact_split(self, payee, amount, users, split_values):
        print("exact split called")
        if amount != sum(split_values):
            raise ValueError("Amounts don't add up")
        for i, user in enumerate(users):
            if payee.id == user.id:
                continue
            payee.moneybook[user.id] += split_values[i]
            user.moneybook[payee.id] -= split_values[i]

    def percent_split(self, payee, amount, users, split_percentages):
        print("percent split called")
        if sum(split_percentages) != 100:
            raise ValueError("Percentages don't add up to 100")
        split_values = [round(amount * percentage / 100, 2) for percentage in split_percentages]
        self.exact_split(payee, amount, users, split_values)


    def show_all(self, users):
        if all(user.moneybook == {} for user in users):
            print("No balances")
        for user in users:
            filtered_moneybook = user.show()
            for key, value in filtered_moneybook.items():
                if value < 0:
                    print(f"{user.id} owes {key} {-value}")
                else:
                    print(f"{key} owes {user.id} {value}")
