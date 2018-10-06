/**
 * Node object
 * @param {data} data 
 */
function Node(data){
    this.data = data;
    this.left = null;
    this.right = null;
}

function LinkedList(){
    this.head = null;
    this.tail = null;
    /**
     * insert data into linked list
     * @param {data} data 
     */
    this.insert = function(data){
        debugger;
        var node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }
        else{
            var listIterator = this.head;
            while(listIterator.right != null){
                listIterator = listIterator.right;
            }
            listIterator.right = node;
            node.left = listIterator;
        }
    };

    /**
     * Delete node from linked list
     * @param {data} data 
     */
    this.delete = function(data){
        if(this.head == null){
            console.log("Linked list is empty!");
        }
        else if(this.head.data === data){
            this.head = this.head.right;
            this.head.left = null;
        }
        else{
            var node = this.head;
            while(node != null){
                if(node.data === data){
                    node.left.right = node.right;
                    break;
                }
                else{
                    node = node.right;
                }
            }
        }
    }

    /**
     * Show all node of linked list
     */
    this.listOFNode = function(){
        var node = this.head;
        if(node == null){
            console.log("Linked list is Empty");
        }
        else{
            while(node != null){
                console.log(node.data);
                node = node.right;
            }
        }
    };
}

function main(){
    var linkedList = new LinkedList();
    linkedList.listOFNode();
    console.log("------------------------------------");
    linkedList.insert("ramjilal");
    linkedList.insert("rajesh");
    linkedList.insert("rahul");
    linkedList.insert("john");
    linkedList.insert("job");
    linkedList.insert("alice");
    linkedList.listOFNode();
    linkedList.delete("ramjilal");
    linkedList.delete("rajesh");
    linkedList.delete("alice");
    console.log("------------------------------------");
    linkedList.listOFNode();
    linkedList.insert("ramjilal");
    console.log("------------------------------------");
    linkedList.listOFNode();
}

main();