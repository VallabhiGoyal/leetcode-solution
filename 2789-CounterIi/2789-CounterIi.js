// Last updated: 4/24/2026, 10:30:48 AM
/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let current = init;
    return {
        increment : function(){
            return ++current;
        },
        reset : function(){
            current = init;
            return current;
        },
        decrement : function(){
            return --current;
        }
        
    };
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */