import java.lang.reflect.Array

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

Range r = Day.MONDAY..Day.SUNDAY
println "Our range's size: ${r.size()}"
println "Our range's first element: ${r.from}"
println "Our range's last element: ${r.to}"
println "Our range contains WEDNESDAY: ${r.contains(Day.WEDNESDAY)}"

ArrayList lst = new ArrayList(Day.MONDAY..Day.SUNDAY)

println "Our list's contents: ${lst}"
println "Our list's size: ${lst.size()}"
ArrayList newLst1 = lst - Day.SATURDAY
println "Our new list without SATURDAY: ${newLst1}"
ArrayList newLst2 = newLst1 + Day.SATURDAY
println "Our newest list with SATURDAY: ${newLst2.sort()}"
println "Our list contains WEDNESDAY on index 2: ${lst[2]}"

Map m = [1:Day.MONDAY, 2:Day.TUESDAY, 3:Day.WEDNESDAY, 4:Day.THURSDAY, 5:Day.FRIDAY, 6:Day.SATURDAY, 7:Day.SUNDAY]

println "Our map's contents: ${m}"
println "Our map's class: ${m.getClass().getName()}"
println "Our map's size: ${m.size()}"
println "Our map's values: ${m.values()}"



