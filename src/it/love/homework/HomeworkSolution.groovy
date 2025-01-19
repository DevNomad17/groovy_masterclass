package it.love.homework

// ---------------------------
//
// HOMEWORK
//
// You can use either Groovy or Java.
//
// Design a routine that will calculate the average Product price per Group.
//
// The Price of each Product is calculated as:
// Cost * (1 + Margin)
//
// Assume there can be a large number of products and a large number of categories.
//
// Plus points:
// - use Groovy and its closures
// - make the category look-up performance effective
// - use method Collection.inject



// contains information about [Product, Group, Cost]
def products = [
        ["A", "G1", 20.1],
        ["B", "G2", 98.4],
        ["C", "G1", 49.7],
        ["D", "G3", 35.8],
        ["E", "G3", 105.5],
        ["F", "G1", 55.2],
        ["G", "G1", 12.7],
        ["H", "G3", 88.6],
        ["I", "G1", 5.2],
        ["J", "G2", 72.4]]

// contains information about Category classification based on product Cost
// [Category, Cost range from (inclusive), Cost range to (exclusive)]
// i.e. if a Product has Cost between 0 and 25, it belongs to category C1
def category = [
        ["C3", 50, 75],
        ["C4", 75, 100],
        ["C2", 25, 50],
        ["C5", 100, null],
        ["C1", 0, 25]]

// contains information about margins for each product Category
// [Category, Margin (either percentage or absolute value)]
def margins = [
        "C1": "20%",
        "C2": "30%",
        "C3": "0.47",
        "C4": "50%",
        "C5": "0.66"]

// ---------------------------
//
// YOUR CODE GOES BELOW THIS LINE
//
// Assign the 'result' variable so the assertion at the end validates
//
// ---------------------------

// Sort categories by lower bound of interval for efficient lookup
def sortedCategories = category.sort { it[1] }

// Function to convert margin strings to numeric values
def convertMargin = { String margin ->
    if (margin.endsWith('%')) {
        return Double.parseDouble(margin[0..-2]) / 100
    } else {
        return Double.parseDouble(margin)
    }
}

// Convert all margins to numeric form
def numericMargins = margins.collectEntries { k, v -> [k, convertMargin(v)] }


def binarySearchForCategory = { double amount ->
    def start = 0
    def end = sortedCategories.size() - 1

    while (start <= end) {
        def mid = (start + end) / 2 as int
        def cat = sortedCategories[mid]
        if (cat[1] <= amount && (cat[2] == null || amount < cat[2])) {
            return cat
        } else if (cat[1] > amount) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return null // No matching category found
}

def findCategoryAndMargin = { double amount ->
    def cat = binarySearchForCategory(amount)

    if (cat) {
        return numericMargins[cat[0]] // Return just the margin value
    } else {
        return 0 // If no category matches, no margin applied
    }
}

// Apply the margin to calculate a new amount:
def applyMargin = { double originalAmount, double margin ->
    originalAmount * (1 + margin)
}

def result = products.groupBy { it[1] }.collectEntries { categ, productsInCategory ->
    def sum = productsInCategory.inject(0) { acc, product ->
        def price = product[2]
        def margin = findCategoryAndMargin(price)
        acc + applyMargin(price, margin)
    }
    [categ, (sum / productsInCategory.size()).round(1)]
}

// ---------------------------
//
// IF YOUR CODE WORKS, YOU SHOULD GET "It works!" WRITTEN IN THE CONSOLE
//
// ---------------------------
assert result == [
        "G1": 38.3,
        "G2": 127.1,
        "G3": 118.2
]: "It doesn't work"

println "It works!"
