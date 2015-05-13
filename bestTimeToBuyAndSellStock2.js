/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
   if( prices === null || prices.length === 0 || prices.length === 1) {
       return 0;
   }
   var res = 0;
   for(var i=1; i<prices.length; i++){
       var diff = prices[i] - prices[i-1];
       if(diff > 0){
           res += diff;
       }
   }
   return res;
};