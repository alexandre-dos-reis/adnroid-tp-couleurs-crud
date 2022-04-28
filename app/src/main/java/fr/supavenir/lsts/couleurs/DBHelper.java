package fr.supavenir.lsts.couleurs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private final static int dbVersion = 1;
    private final static String dbName="couleursDB";
    private static SQLiteDatabase db = null;

    public DBHelper(Context context) {
        super(context, dbName, null, dbVersion);
        db = this.getWritableDatabase();
    }


    public void deleteCouleurByNom( String nom ) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = { nom };
        db.delete( "Couleur" ,"nom=?", args );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Couleur (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, a INTEGER," +
                " r INTEGER, g INTEGER, b INTEGER );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int indexVersion = oldVersion; indexVersion < newVersion;
             indexVersion++) {
            int nextVersion = indexVersion + 1;
            switch (nextVersion) {
                case 2:
                    // upgrapdeToVersion2(db);
                    break;
                case 3:
                    // mise à jour future pour la version 3
                    break;
            }

        }
    }

    public List<Couleur> getAllColors()
    {
        return (List<Couleur>) db.rawQuery("Select * from Couleur;", null);
    }

    public void createCouleur(Couleur couleur)
    {
        db.insert("Couleur", null, toContentValues(couleur));
    }

    private ContentValues toContentValues(Couleur couleur)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nom", couleur.nom );
        contentValues.put("a", couleur.a );
        contentValues.put("r", couleur.r );
        contentValues.put("g", couleur.g );
        contentValues.put("b", couleur.b );
        return contentValues;
    }

    public Couleur readCouleur(String id)
    {
        return (Couleur) db.rawQuery("Select * from Couleur where id = ?", new String[]{id});
    }

    public void updateCouleur(Couleur couleur)
    {
        db.update(
                "Couleur",
                toContentValues(couleur),
                "id=?",
                new String[]{String.valueOf(couleur.getId())}
        );
    }

    public void deleteCouleur(Couleur couleur)
    {
        db.delete(
                "Couleur",
                "id=?",
                new String[]{String.valueOf(couleur.getId())}
        );
    }
}
