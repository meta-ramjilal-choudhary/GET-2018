//Stack class
function Stack(){
    this.arr = [];
}

/**
 * insert data at the end of the stack
 * @param {data} data 
 */
Stack.prototype.push = function(data){
    this.arr.push(data);
};

/**
 * remove top element of the stack
 */
Stack.prototype.pop = function(){
    return this.arr.pop();
};

/**
 * return size of the stack
 */
Stack.prototype.size = function(){
    return this.arr.length;
};

/**
 * return top element of the stack
 */
Stack.prototype.peek = function(){
    return this.arr[this.arr.length-1];
};

function main(){
    var stack = new Stack();
    stack.push("Ramjilal");
    stack.push("Vaibhav");
    console.log(stack.peek());
    console.log(stack.size());
    console.log(stack.pop());
    console.log(stack.peek());
}

main();