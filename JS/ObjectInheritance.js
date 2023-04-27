/*
//Model
function Person(){
    this.name;
    this.surname;
    this.isHuman=false;
    this.printHi=function(){
        console.log("My name is "+ this.name +", Human= "+ this.isHuman);
    }
}

let pippo = new Person();
pippo.printHi(); // My name is undefined, Human= false;

let Mat= Object.create(pippo); //Pippo is used as model for another object
Mat.printHi(); // My name is undefined, Human= false;

Mat.name="Mat";
Mat.surname="Dan";
Mat.isHuman=true;
Mat.printHi(); // My name is Mat, Human= true
*/

/*
//Prototype based inheritance 1

function Person(n,s){
    this.firstname=n;
    this.lastname=s;

}
Person.prototype.nickname="The Best";
Person.prototype.fullname= function(){
    return this.firstname + " "+ this.lastname;
};

//IMPLICIT:
//Person.prototype = Object.create(Object.prototype);
//Object.defineProperty(Person.prototype, 'constructor', {
//    value: Person, enumerable: false, writable:true}
//);

function Athlete(n,s, sport){
    Person.call(this, n, s);
    this.sport=sport;
}
Athlete.prototype = Object.create(Person.prototype); // use the Person prototype
Object.defineProperty(Athlete.prototype, 'constructor', {
    value: Athlete, enumerable: false, writable:true}
);

let person1= new Athlete("Michael", "Jordan","PingPong");
let person2= new Athlete("Yohan", "Blake","Swimming");
console.log(person1.fullname()+" "+ person1.sport+ " " + person1.nickname);
console.log(person2.fullname()+" "+ person2.sport+ " " + person2.nickname);

*/