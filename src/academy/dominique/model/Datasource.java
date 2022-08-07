package academy.dominique.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\nguet\\Documents\\Tuto personnel\\Music\\"+DB_NAME;

    //////////////// TABLE ALBUM INFOS //////////////////
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUMS_NAME = "_name";
    public static final String COLUMN_ALBUMS_ARTIST = "_artist";

    //////////////// TABLE ALBUM ARTISTS //////////////////
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";

    //////////////// TABLE ALBUM SONGS //////////////////
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TRACK = "track";
    public static final String COLUMN_SONGS_TITLE = "titre";
    public static final String COLUMN_SONGS_ALBUM = "album";

    private Connection con;

    public boolean open(){
        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e){
            System.out.println("Something get wrong "+e.getMessage());
            return false;
        }
    }

    public void close(){
        try {
            if (con != null){
                con.close();
            }
        } catch (SQLException e){
            System.out.println("Couldn't close "+e.getMessage());
        }
    }

}
