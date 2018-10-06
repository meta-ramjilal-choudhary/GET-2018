/**
 * Node object
 * @param {data} data 
 */
function Node(data){
    this.data = data;
    this.next = null;
}

function LinkedList(){
    this.head = null;

    /**
     * insert data into linked list
     * @param {data} data 
     */
    this.insert = function(data){
        var node = new Node(data);
        if(this.head == null){
            this.head = node;
        }
        else{
            var listIterator = this.head;
            while(listIterator.next != null){
                listIterator = listIterator.next;
            }
            listIterator.next = node;
        }
    };

    /**
     * Delete node from linked list
     * @param {*} data 
     */
    this.delete = function(data){
        if(this.head == null){
            console.log("Linked list is empty!");
        }
        else if(this.head.data === data){
            this.head = this.head.next;
        }
        else{
            var node = this.head;
            var preNode = node;
            while(node != null){
                if(node.data === data){
                    preNode.next = node.next;
                    break;
                }
                else{
                    preNode = node;
                    node = node.next;
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
                node = node.next;
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
    linkedList.delete("rajesh");
    linkedList.delete("ramjilal");
    linkedList.delete("alice");
    console.log("------------------------------------");
    linkedList.listOFNode();
    linkedList.insert("ramjilal");
    console.log("------------------------------------");
    linkedList.listOFNode();
}

main();