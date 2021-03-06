const { Map } = require('immutable');
const map1 = Map({ a: 1, b: 2, c: 3 });
const map2 = map1.set('b', 50);
console.log(
map1.get('b') + " vs. " + map2.get('b')
);


// import Immutable from require('immutable');
// var map1: Immutable.Map<string, number>;
// map1 = Immutable.Map({ a: 1, b: 2, c: 3 });
// var map2 = map1.set('b', 50);
// map1.get('b'); // 2
// map2.get('b')