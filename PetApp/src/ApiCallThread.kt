import java.net.URL

interface Get{
    fun Run()
}

class RandomPet : Get{
  override fun Run(){
      val result = URL("http://api.petfinder.com/pet.getRandom?key=8c471c274a06a2a995c86e269b15f016&output=basic").readText()
  }
}