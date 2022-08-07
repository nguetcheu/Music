package academy.dominique.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\nguet\\Documents\\Tuto personnel\\Music\\"+DB_NAME;

    //////////////// TABLE ALBUM INFOS //////////////////
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    //////////////// TABLE ALBUM ARTISTS //////////////////
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    //////////////// TABLE ALBUM SONGS //////////////////
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    private Connection con;

    public boolean open(){
        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e){
            System.out.println("Couldn't connect to database: "+e.getMessage());
            return false;
        }
    }

    public void close(){
        try {
            if (con != null){
                con.close();
            }
        } catch (SQLException e){
            System.out.println("Couldn't close connection "+e.getMessage());
        }
    }
    public List<Artist> queryArtists(){

        try(Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM "+ TABLE_ARTISTS)) {

            List<Artist> artists = new ArrayList<>();
            while (results.next()){
                Artist artist = new Artist();
                artist.setId(results.getInt(COLUMN_ARTIST_ID));
                artist.setName(results.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;

        } catch (SQLException e){
            System.out.println("Query failed "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
