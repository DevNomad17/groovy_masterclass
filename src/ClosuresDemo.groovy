def cl = {
    println "Greetings from closure: $it"
}

//cl("abrakadabra")

def customIntroText(def text) {
    text("unimatrix 0 has U!!!")
}

//customIntroText(cl)

ArrayList lst = new ArrayList(Day.MONDAY..Day.SUNDAY)

//lst.each {
//    print "$it "
//}

Map m = [1:Day.MONDAY, 2:Day.TUESDAY, 3:Day.WEDNESDAY, 4:Day.THURSDAY, 5:Day.FRIDAY, 6:Day.SATURDAY, 7:Day.SUNDAY]

//m.each {
//    println "Key: $it.key, Value: $it.value"
//}

def addThreeNums = {Integer a, Integer b, Integer c ->
    println "The result is: ${a+b+c}"
}

def addTwoNumsOffsetTen = addThreeNums.curry(10)

print "Adding 1+2+3 using closure addThreeNums: "
addThreeNums(1, 2, 3)
print "Adding 2+3 offset by ten using closure addTwoNumsOffsetTen: "
addTwoNumsOffsetTen(2, 3)

print "Demo of ArrayList.findAll(): "
println lst.findAll {
    it == Day.SATURDAY
}

print "Demo of ArrayList.any(): "
println lst.any {
    it == Day.SATURDAY
}

print "Demo of ArrayList.every(): "
println lst.every {
    it == Day.SATURDAY
}

print "Demo of ArrayList.groupBy(): "
println lst.groupBy {
    it == Day.SATURDAY
}