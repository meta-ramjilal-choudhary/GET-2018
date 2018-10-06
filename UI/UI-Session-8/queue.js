function Queue(){
    this.arr = [];
}

/**
 * insert data end of the queue
 * @param {data} data 
 */
Queue.prototype.enqueue = function(data){
    this.arr.push(data);
};

/**
 * remove data front of the queue
 */
Queue.prototype.dequeue = function(){
    return this.arr.shift();
};

/**
 * return size of the queue
 */
Queue.prototype.size = function(){
    return this.arr.length;
};

/**
 * return front data of the queue
 */
Queue.prototype.front = function(){
    return this.arr[0];
};

/**
 * return end data of the queue
 */
Queue.prototype.end = function(){
    return this.arr[this.arr.length-1];
};

function main(){
    var queue = new Queue();
    queue.enqueue("Ram");
    queue.enqueue(12);
    queue.enqueue(["rahul", "jitu"]);
    queue.enqueue("vaibhav");
    queue.enqueue(12.3434);
    console.log("size: " + queue.size());
    console.log("front data : " + queue.front());
    console.log("End data: " + queue.end());
    console.log("removed data: " + queue.dequeue());
    console.log("Size: " + queue.size());
    console.log("Front: " + queue.front());
    console.log("End: " + queue.end());
    console.log("removed data: " + queue.dequeue());
    console.log("Size: " + queue.size());
    console.log("Front: " + queue.front());
    console.log("End: " + queue.end());
}

main();