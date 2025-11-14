const { randomUUID } = require("crypto");

class List {
  constructor(id, name, cards = {}, manager) {
    this.id = randomUUID();
    this.name = name || "";
    this.cards = cards;
    manager.objects[id] = this;
  }

  deleteList() {
    delete this.manager.objects[this.id];
  }

  getListDetails() {
    return {
      id: this.id,
      name: this.name,
      cards: Object.keys(this.cards).map((cardId) =>
        this.cards[cardId].getCardDetails()
      ),
    };
  }
}

module.exports = List;
