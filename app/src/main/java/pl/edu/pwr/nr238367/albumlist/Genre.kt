package pl.edu.pwr.nr238367.albumlist


enum class Genre(val toString:String){
    ROCK("ROCK"),
    RAP("RAP"),
    JAZZ("JAZZ"),
    POP("POP"),
    SOUL("SOUL"),
    OTHER("OTHER");
}
fun genreFromString(genre:String):Genre{
    return Genre.values().find { it.toString == genre.toUpperCase() } ?: Genre.OTHER
}