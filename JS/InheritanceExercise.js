function A(p) {
    this.a1 = p;
    this.a2 = "two";
}

A.prototype.a3 = "three";
A.prototype.a4 = "four";

function B(p) {
    A.call(this, p);
    this.b1 = "five";
}
/*
B.prototype = Object.create(A.prototype);
Object.defineProperty(B.prototype, 'constructor', {
    value: B, enumerable: false, writable: true
});

*/
B.prototype.a4="six";


let v1= new A("one_a");
let v2= new B("one_b");
for(e in v1){
    console.log("=> A " + e + " " +v1[e]);
}

for(e in v2){
    console.log("B " + e + " " +v2[e]);
}




/*
    Solution:
    -let v1= new A("one_a") --> sets v1.a1= one_a
    in the first iteration all the pairs param-values of v1 are printed, both from the object instantiation and prototype
    so
    line 1) => A a1 one_a                (parameter found in A constructor, passed as parameter)
    line 2) => A a2 two                  (parameter found in A constructor, as default)
    line 3) => A a3 three                (parameter found in A prototype)
    line 4) => A a4 four                  (parameter found in A prototype)

    -let v2= new B("one_b");    ---> Here the situation is more complex, let's analyze the steps:

     when B is called the A is called and a1,a2, are set from A, then B ads b1=five, the protype of B inheriting from A ads a3,a4
     and then  a4="six" overwrites the already present parameter to the prototype of B
      so overall:
        a1,a2 are "inherited" by the B constructor that calls the A constructor, and a1="one_b" because is the passed parameter
        a3, a4 are "Inherited" by the B prototype that is based on the A prototype
        b1 is added by the B constructor and a4 is changed by the B prototype

     line 5) B a1 one_b
     line 6) B a2 two
     line 7) H b1 five
     line 8) B a4 six
     line 9) B a2 three

     NB: The order of the output can change
 */