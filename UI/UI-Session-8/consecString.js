/**
 * remove the consecutive repeating string
 * @param {Repeating string} string 
 */
function removeConsecString(string){
    var startIndexOfRepString = 0;
    var endIndexOfRepString = 0;
    for(var index=1; index<string.length; index++){
        if(string.slice(index, index+1) === string.slice(index-1, index)){
            endIndexOfRepString = index;
        }
        else{
            if((endIndexOfRepString - startIndexOfRepString)<=0){
                startIndexOfRepString = index;
                continue;
            }
            else{
                return removeConsecString(string.slice(0, startIndexOfRepString) +
                    string.slice(endIndexOfRepString+1, string.length+1));
            }
        }
    }
    return string;
}

function main(){
    console.log(removeConsecString("aabccbd"));
    console.log(removeConsecString("cbd"));
    console.log(removeConsecString("aabcffhxxxhcbd"));
    console.log(removeConsecString("eeabcddcbfgf"));
}

main();