@groovy.transform.ToString
class Car {
    String color, fuel, maker

    def invokeMethod(String name, Object args) {
        println "Nonexistent method was called: $name"
    }
}

Car c1 = new Car(color: "Red", fuel: "BEV", maker: "Tesla")

println c1.color
c1.maker = "Rivian"
println c1

println "Adding method 'drive' to an object in runtime"
// Dynamically add the method to the single instance
c1.metaClass.drive = { String speed ->
    return "This $delegate.maker is driving really $speed!!"
}

// Call the dynamically added method
println c1.drive("fast")
println c1


Expando e1 = new Expando()
e1.wings = "long"
e1.beak = "sharp"
e1.fly = {String name -> "$name is flying high with $wings wings and $beak beak"}
println e1.fly("Stupiter")

Integer.metaClass.timesTwo = {-> delegate*2}
Integer i = 5
print "Calling custom method 'timesTwo()' on integer: " + i.timesTwo()