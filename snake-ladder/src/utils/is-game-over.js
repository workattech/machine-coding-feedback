const { endPoint } = require('../consts.js');

exports.default = (positions) => positions.some(position => position === endPoint);