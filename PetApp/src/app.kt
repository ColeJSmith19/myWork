fun main(args: Array<String>){
    val random = RandomPet()
    random.Run()

    fetchJson()
}

fun fetchJson(){
    println("Fetching...")
    val url = "http://api.petfinder.com/pet.getRandom?key=8c471c274a06a2a995c86e269b15f016&output=basic"

}

