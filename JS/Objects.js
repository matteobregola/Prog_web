/*
var person = { firstName: "Mark", lastName: "Buffalo", fullName: function(){
        return this.firstName + " "+ this.lastName;}
}

var object1 = new Object();
// takes an object, a property name and a descriptor
Object.defineProperty(
    object1, 'name',
    {value: "AA", writable: false}
);
object.name=77;
console.log(object1.name);


function Rectangle(w,h){
    this.width=w;
    this.height=h;
    this.area=function(){return this.width*this.height}
}

a=new Rectangle(2,3);
b=new Rectangle(2,3)
a.area= function (){return 100};
console.log(a.area());  // output= 100
console.log(b.area()); // output = 6
*/
function Person(n,s){
    this.name=n;
    this.surname=s;
}

Person.prototype.fullName=function(){return this.name + " "+ this.surname};
Person.prototype.nick="Nickname";

let p1= new Person("James", "Sullivan");
let p2= new Person("Mike","Wazowski");

//console.log(p1.nick); // =>Nickname
//console.log(p2.nick); // =>Nickname

p2.nick="Hello";

//console.log(p1.nick); // =>Nickname
//console.log(p2.nick); // =>Hello

Person.prototype.nick="Sara";

//console.log(p1.nick); // =>Sara
//console.log(p2.nick); // =>Hello

x = new Person("Mark", "Evans");
for (let e in x){
    //console.log(e+" "+x[e]);
}
Object.defineProperty(x,"age",{value: 33, enumerable: false}); //adds a non-enumerable property
y= Object.getOwnPropertyNames(x);
console.log(y);
for(let e of y){
    if(x.propertyIsEnumerable(e)){
        console.log(e+ " "+ x[e]);
    }
}