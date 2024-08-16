exports.default = (users) => {
    return users.reduce((acc, user) => {
        acc[user] = users.reduce((acc1, user1) => {
            if(user1 != user) {
                acc1[user1] = 0;
            }
            return acc1
        }, {});
        return acc;
    }, {})
}