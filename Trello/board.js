const { randomUUID } = require("crypto");

class Board {
  constructor(id, name, privacy = "PUBLIC", url, memebersLists = {}, manager) {
    this.id = randomUUID();
    this.name = name || "";
    this.privacy = privacy;
    this.url = url;
    this.memebersLists = memebersLists;
    manager.objects[id] = this;
  }

  deleteBoard() {
    delete this.manager.objects[this.id];
  }

  getBoardDetails() {
    return {
      id: this.id,
      name: this.name,
      privacy: this.privacy,
      ...(this.url && { url: this.url }),
      ...(this.memebers?.length > 0 && {
        memebersLists: Object.keys(this.memebersLists).map((listId) =>
          this.memebersLists[listId].getListDetails()
        ),
      }),
    };
  }
}

module.exports = Board;
