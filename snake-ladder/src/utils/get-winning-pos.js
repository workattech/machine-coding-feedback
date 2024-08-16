const { endPoint } = require('../consts.js'); 

exports.default = (positions) => positions.findIndex(position => position === endPoint);