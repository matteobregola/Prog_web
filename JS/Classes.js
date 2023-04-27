class Person{
    constructor(f,l) {
        this.firstName = f;
        this.lastName = l;
    }
    fullname(){
        return this.firstName+" "+this.lastName;
    }
    maxAge=300;
}
class Athlete extends Person{
    constructor(f,l,s){
        super(f,l);
        this.sport=s;
    }
}


let person1= new Athlete("Michael", "Jordan","PingPong");
let person2= new Athlete("Yohan", "Blake","Swimming");
console.log(person1.fullname()+" "+ person1.sport);
console.log(person2.fullname()+" "+ person2.sport);

Person.minAge=0;
Person.prototype.maxHeight=250;
let person0=new Person("Bob", "Billie");
console.log(person0.maxAge); // 300
console.log(person0.minAge); //undefined
console.log(person0.maxHeight); // 250
console.log(Person.maxAge);  //undefined
console.log(Person.minAge); // 0
console.log(Person.maxHeight); // undefined

class Persons{
    constructor(f,l) {
        this.firstName = f;
        this.lastName = l;
    }
    fullname(){
        return this.firstName+" "+this.lastName;
    }
    static names(p){
        return p.firstName;
    }
}

let pers= new Persons("Fernando", "Alonso");
console.log(Persons.names(pers)); // Fernando