package com.example.knox.systemComponents;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

//Todo: implement password generation algorithm
@androidx.room.Database(entities = {Credentials.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract PasswordDAO passDao();
    private static volatile Database INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "credentials")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
//    private static volatile Database instance = null;
//    public Database(){}
//    public static Database getInstance(){
//        if(instance == null){
//            //instance = new Database();
//        }
//        return instance;
//    }

    //Todo: implement password generation algorithm
    private void generate(int length){
        boolean hasUpper, hasLower, hasNum, hasSym;
        String password = "";
        for(int i = 0; i < length; i++) {
            //generate ASCII value for valid character
            int currentChar = ThreadLocalRandom.current().nextInt(33, 123);
            //switch to check which boolean flags are satisfied
            switch(currentChar){
                case (1):

            }
            password += (char) currentChar;
        }
    }
}
