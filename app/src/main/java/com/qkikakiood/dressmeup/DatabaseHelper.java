//package com.qkikakiood.dressmeup;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteException;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.graphics.Bitmap;
//import android.os.Build;
//import android.os.Environment;
//import android.util.Log;
//
//import com.qkikakiood.dressmeup.ImageHelper;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
///**
// * Created by a on 18.7.2016 г..
// */
//public class DatabaseHelper extends SQLiteOpenHelper {
//    private Context context;
//    private SQLiteDatabase myDatabase;
//    private final String TAG = "DatabaseHelperClass";
//    private static final int databaseVersion = 1;
//    private static final String DB_NAME = "dbTest";
//    private static String DB_PATH = "";
//    private static final String TABLE_IMAGE = "ImageTable";
//    // Image Table Columns names
//    private static final String COL_ID = "col_id";
//    private static final String IMAGE_ID = "image_id";
//    private static final String IMAGE_BITMAP = "image_bitmap";
//
//
//    public DatabaseHelper(Context context) {
//        super(context, DB_NAME, null, databaseVersion);
//        if(Build.VERSION.SDK_INT>=15){
//            DB_PATH=context.getApplicationInfo().dataDir+"/databases/";
//        }else{
//            DB_PATH= Environment.getDataDirectory() + "/data/" + context.getPackageName() + "/databases/";
//        }
//
//        this.context = context;
//    }
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String CREATE_IMAGE_TABLE = "CREATE TABLE " + TABLE_IMAGE + " ("
//                + COL_ID + " INTEGER PRIMARY KEY ,"
//                + IMAGE_ID + " TEXT,"
//                + IMAGE_BITMAP + " TEXT )";
//        sqLiteDatabase.execSQL(CREATE_IMAGE_TABLE);
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        // Drop older table if existed
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGE);
//        onCreate(sqLiteDatabase);
//    }
//    public void checkAndCopyDatabase(){
//        boolean dbExist = checkDatabase();
//        if(dbExist){
//            Log.d("TAG", "database already exist");
//        }else{
//            this.getReadableDatabase();
//        }
//        try {
//            copyDatabase();
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.d("TAG", " Error copy database");
//        }
//    }
//
//    public void openDatabase() {
//        String myPath = DB_PATH + DB_NAME;
//        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
//    }
//
//    public void copyDatabase() throws IOException{
//        InputStream myInput=context.getAssets().open(DB_NAME);
//        String outFileName = DB_PATH + DB_NAME;
//        OutputStream myOutput = new FileOutputStream(outFileName);
//        byte[] buffer = new byte[1024];
//        int lenght;
//        while((lenght=myInput.read(buffer))>0){
//            myOutput.write(buffer,0,lenght);
//        }
//        myOutput.flush();
//        myOutput.close();
//        myInput.close();
//    }
//
//    public Cursor QueryData(String query){
//        return myDatabase.rawQuery(query,null);
//    }
//
//    public boolean checkDatabase(){
//        SQLiteDatabase checkDB=null;
//        try {
//            String myPath = DB_PATH + DB_NAME;
//            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
//        }catch (SQLiteException e){
//
//        }
//        if(checkDB!=null){
//            checkDB.close();
//        }
//        return checkDB!=null ? true : false;
//    }
//    public void insetImage(Bitmap bitmap, String imageId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(IMAGE_ID, imageId);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        values.put(IMAGE_BITMAP, stream.toByteArray());
//        db.insert(TABLE_IMAGE, null, values);
//        db.close();
//    }
//    public ImageHelper getImage(String imageId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor2 = db.query(TABLE_IMAGE,
//                new String[] {COL_ID, IMAGE_ID, IMAGE_BITMAP},IMAGE_ID
//                        +" LIKE '"+imageId+"%'", null, null, null, null);
//        ImageHelper imageHelper = new ImageHelper();
//        if (cursor2.moveToFirst()) {
//            do {
//                imageHelper.setImageId(cursor2.getString(1));
//                imageHelper.setImageByteArray(cursor2.getBlob(2));
//            } while (cursor2.moveToNext());
//        }
//        cursor2.close();
//        db.close();
//        return imageHelper;
//    }
//}