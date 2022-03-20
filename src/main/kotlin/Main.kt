class Person{
    var name: String = ""
    var surname: String = ""
    var age: Int = 0

    fun showInfo(){
        println("$name $surname $age")
    }

    fun welcome(greeting: String){
        println("$greeting $name $surname")
    }

    fun checkTakeLoan(){

        if (age >= 18){
            println("$name, Вы можете взять кредит!")
        }
        else{
            println("$name, пока наслаждайтесь жизнью без кредита)")
        }
    }

    fun clone(): Person{
        var clonePerson = Person()
        clonePerson.name = name
        clonePerson.surname = surname
        clonePerson.age = age
        return clonePerson
    }

    fun laptopsFit(laptops: ArrayList<Notebook>): ArrayList<Notebook>{
        var res = ArrayList<Notebook>()

        for (laptop in laptops){
            if (laptop.capacity > 250 && laptop.ram >= 8){
                res.add(laptop)
            }
        }
        return res
    }

}

class Notebook {
    var brand: String = ""
    var model: String = ""
    var screenDiagonal: Float = 0.0f
    var proc: String = ""
    var ram: Int = 0
    var capacity: Int = 0

    fun setData(number: Int){
        println("Укажите брэнд ноутбука №${number}?")
        brand = readLine().toString()
        println("Укажите модель ноутбука №${number}?")
        model = readLine().toString()
        println("Укажите диагональ?")
        screenDiagonal = readLine().toString().toFloat()
        println("Укажите название процессора №${number}?")
        proc = readLine().toString()
        println("Сколько оперативной памяти №${number}?")
        ram = readLine().toString().toInt()
        println("Обьем внутренней памяти №${number}?")
        capacity = readLine().toString().toInt()
    }

    fun showInfo(){
        println("$brand, $model, $screenDiagonal, $proc, $ram, $capacity")
    }
}


fun main(args: Array<String>) {
    var person1 = Person()
    person1.name = "Николай"
    person1.surname = "Иванов"
    person1.age = 18
    person1.showInfo()
    person1.welcome("Здрасте! ")
    person1.checkTakeLoan()

    var person2 = person1
    person2.age = 20
    println(person1.age)

    var person3 = person1.clone()
    person3.age = 30
    println(person1.age)

    var laptopsToCheck = ArrayList<Notebook>()
    for (i in 1..2){
        var newLaptopToCheck = Notebook()
        newLaptopToCheck.setData(i)
        laptopsToCheck.add(newLaptopToCheck)
    }

    var res = person1.laptopsFit(laptopsToCheck)
    res.forEach{
        println(it.showInfo())
    }

}

// Задание на уроке №1
// Создать класс Money для работы с денежными суммами. Число должно быть представлено двумя полями: количество рублей и копеек
// Дробная часть при выводе на экран должна быть отделена от целой части запятой. Реализовать сложение, вычитание, деление и
// умножение сумм на дробное число и операции сравнения