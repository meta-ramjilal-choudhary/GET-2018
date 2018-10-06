function main(){
    String.prototype.repeatify = function(n){
        var result = "";
        for(var i=1; i<=n; i++){
            result += this;
        }
        return result;
    };
    console.log("ram".repeatify(5));
}   

main();