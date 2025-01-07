import groovy.xml.MarkupBuilder

def arrBooks = [
        [isbn:"978-1935182443", title:"Groovy in Action 2nd Edition", author:"Dierk Koenig", price:50.58],
        [isbn:"978-1935182948", title:"Making Java Groovy", author:"Ken Kousen", price:33.96],
        [isbn:"978-1937785307", title:"Programming Groovy 2: Dynamic Productivity for the Java Developer",
            author:"Venkat Subramaniam", price:28.92]
    ]

FileWriter fw = new FileWriter("books.xml")
MarkupBuilder builder = new MarkupBuilder(fw)

builder.xml {
    head {
        title "Some fancy groovy books - check them out!!!"
    }
    books {
        arrBooks.each { map ->
            book("isbn": map["isbn"]) {
                title "${map['title']}"
                author "${map['author']}"
                price "${map['price']}"
            }
        }
    }
}

