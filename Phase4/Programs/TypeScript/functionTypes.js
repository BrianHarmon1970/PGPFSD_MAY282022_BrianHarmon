// function parameters
function add(a, b) {
    console.log(a + " " + b);
}
function empInfo(id, name, age) {
    console.log(id + " " + name + " " + age);
}
empInfo(100, "Ravi", 33);
// function with no return type
function info() {
    return;
}
// function with return type
function sayHello() {
    return "Hello";
}
// function with number return type
function getNumber() {
    return 100;
}
// function with 'any' return type
function greeting() {
    return "welcome";
}
// optional parameters 
function studentInfo(sid, sname, age) {
}
// default parameters 
function studentInfo2(sid, sname, age) {
    if (sid === void 0) { sid = 100; }
    if (age === void 0) { age = 33; }
}
studentInfo(100, "Ravi", 21);
studentInfo(101, "Lokesh");
studentInfo(102);
studentInfo();
studentInfo2(100, "Ravi", 21);
studentInfo2(101, "Lokesh");
studentInfo2(102);
studentInfo2();
