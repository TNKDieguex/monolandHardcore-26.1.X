package net.dieguex.monolandhardcore.util;

import net.dieguex.monolandhardcore.MonolandHardcore;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;

public class TimeManagerMod {
    private static final File timeFile = new File("mod_data/first_boot.txt");
    private static Instant startTime;

    public static void init(){
        try{
            if(!timeFile.exists()){
                timeFile.getParentFile().mkdirs();
                Files.writeString(timeFile.toPath(), Instant.now().toString());
            }
            String saved = Files.readString(timeFile.toPath());
            startTime = Instant.parse(saved);
        }catch (Exception e){
            MonolandHardcore.LOGGER.error("Error initializing TimeManagerMod: " + e.getMessage());
            startTime = Instant.now();
        }
    }
    public static void simulateDaysPassed(int days){
        Instant simulatedStart = Instant.now().minus(Duration.ofDays(days));
        try{
            Files.writeString(timeFile.toPath(), simulatedStart.toString());
            startTime = simulatedStart;
        }catch (Exception e){
            MonolandHardcore.LOGGER.error("Error simulating days passed: " + e.getMessage());
        }
    }

    public static boolean hasPassedDays(int days){
        return Duration.between(startTime, Instant.now()).toDays() >= days;
    }
    public static int getDayPassed(){
        return (int) Duration.between(startTime, Instant.now()).toDays();
    }
}
