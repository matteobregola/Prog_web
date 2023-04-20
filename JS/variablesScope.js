{
    x=4;
    var y=5;
    let z=6;
}
console.log(x);   // output=4
console.log(y);   // output=5
//console.log(z);   // Reference Error

function doSomething(){
    a = 4;
    var b = 5;
    let c = 6;
}
doSomething();
console.log(a); // output=4
//console.log(b); // Reference Error
//console.log(c); // Reference Error
