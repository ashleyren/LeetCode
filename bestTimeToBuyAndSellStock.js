/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if(prices === null || prices.length === 0 || prices.length === 1){
        return 0;
    }
    var global = 0;
    var local = 0;
    for(var i=1; i< prices.length; i++){
        local = Math.max(local + prices[i] - prices[i-1], 0);
        global = Math.max(local, global);
    }
    return global;
};