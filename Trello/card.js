const { randomUUID } = require("crypto");

class Card {
  constructor(id, name, description, assignedUser = {}, manager) {
    this.id = randomUUID();
    this.name = name || "";
    this.description = description;
    this.assignedUser = assignedUser;
    manager.objects[id] = this;
  }

  deleteCard() {
    delete this.manager.objects[this.id];
  }

  getCardDetails() {
    return {
      id: this.id,
      name: this.name,
      description: this.description,
      assignedUser:
        Object.keys(this.assignedUser)?.length > 0
          ? this.assignedUser[
              Object.keys(this.assignedUser)[0]
            ].getUserDetails()
          : "DEFAULT",
    };
  }
}

module.exports = Card;
