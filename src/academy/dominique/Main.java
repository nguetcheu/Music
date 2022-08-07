package academy.dominique;

import academy.dominique.model.Datasource;

public class Main {
    public static void main(String[] args) {
        Datasource db = new Datasource();

        if (!db.open()){
            System.out.println("Can't open datasource");
            return;
        }
        db.close();
    }
}