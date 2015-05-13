/**
 * @param {number[]} A
 * @return {number}
 */
var firstMissingPositive = function(A) {
    var len = A.length;
    var i = 0;
    var j = 0;
    while(i < len){
        if(A[i] <= len && A[i] > 0 && A[i] != A[A[i]-1]){
            var tmp = A[A[i]-1];
            A[A[i]-1] = A[i];
            A[i] = tmp;
        } else{
            i++;
        }
    }
    
    while(j < len){
        if(A[j] != j+1) return j+1;
        j++;
    }
    return len+1;
    
};