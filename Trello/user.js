const { randomUUID } = require("crypto");

class User {
  constructor(id, name, email, manager) {
    this.id = randomUUID();
    this.name = name || "";
    this.email = email;
    manager.objects[id] = this;
  }

  deleteUser() {
    delete this.manager.objects[this.id];
  }

  getUserDetails() {
    return {
      id: this.id,
      name: this.name,
      email: this.email,
    };
  }
}

module.exports = User;
