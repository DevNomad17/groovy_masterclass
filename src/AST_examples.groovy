import groovy.transform.CompileStatic
import groovy.transform.Sortable
import groovy.transform.ToString

@CompileStatic
class Calculator {
    Integer add(int a, int b) {
        def c = 0
        c = a + b
        return c
    }
}

def calc = new Calculator()
println calc.add(10, 20) // Output: 30


@Sortable
@ToString

class Person {
    String name
    int age
}

def people = [
        new Person(name: 'Ondrej', age: 30),
        new Person(name: 'Mariška', age: 25),
        new Person(name: 'Filipko', age: 20)
]

// Sort by age (default order)
def sortedByAge = people.sort()
println sortedByAge // Output: [Person(name:Filipko, age:20), Person(name:Mariška, age:25), Person(name:Ondrej, age:30)]

// Sort by name explicitly
def sortedByName = people.sort(Person.comparatorByName())
println sortedByName // Output: [Person(name:Filipko, age:20), Person(name:Mariška, age:25), Person(name:Ondrej, age:30)]


