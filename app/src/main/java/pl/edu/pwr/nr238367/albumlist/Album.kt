package pl.edu.pwr.nr238367.albumlist

data class Album(
        val albumName: String,
        val artistName: String,
        val genreInfo: Genre,
        val photos:ArrayList<String>,
        val artists :ArrayList<Person>)
