from collections import defaultdict


class User:

    def __init__(self, id, name, email, mobile):
        self.id = id
        self.name = name
        self.email = email
        self.mobile = mobile
        self._moneybook = defaultdict(int)

    def show(self):
        # code can be improved
        # print("Showing moneybook for", self.name)
        filtered_moneybook = {}
        for key, value in self._moneybook.items():
            if value != 0:
                filtered_moneybook[key] = value
        return filtered_moneybook

    @property
    def moneybook(self):
        return self._moneybook

    @moneybook.setter
    def moneybook(self, transaction):
        payee, amount, transaction_type = transaction
        if transaction_type == "lent":
            self._moneybook[payee] += amount
        else:
            self._moneybook[payee] -= amount

    def __repr__(self):
        return f"User({self.id}, {self.name})"
