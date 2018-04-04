package pl.edu.pwr.nr238367.albumlist

import java.util.*

object AlbumList {
    val albumList:ArrayList<Album> = initializeList()
    private fun initializeList(): ArrayList<Album> {
        val albumList = ArrayList<Album>()
        val albumFile = this::class.java.getResource("/albumText.txt").readText()
        val scanner = Scanner(albumFile)
        while (scanner.hasNextLine()) {
            val albumName = scanner.nextLine()
            val artist = scanner.nextLine()
            val genre = scanner.nextLine()
            //val album = Album(scanner.nextLine(), scanner.nextLine(), scanner.nextLine())
            val prefix = scanner.next()
            val photoList = ArrayList((1..scanner.nextInt()).map { "$prefix$it"})
            val artists = ArrayList((1..scanner.nextInt()).map {
                val firstName = scanner.next()
                val lastName = scanner.next()
                //skip the rest of the line
                scanner.nextLine()
                val dateScanner = Scanner(scanner.nextLine())
                val birthday = Calendar.getInstance().createDate(dateScanner.nextInt(), dateScanner.nextInt(), dateScanner.nextInt())
                val dayOfDeath = if (dateScanner.hasNextInt()) Calendar.getInstance().createDate(dateScanner.nextInt(), dateScanner.nextInt(), dateScanner.nextInt()) else null
                Person(firstName, lastName, birthday, dayOfDeath)
            })
            albumList.add(Album(albumName, artist, genreFromString(genre), photoList, artists))
        }
        return albumList
    }
}


