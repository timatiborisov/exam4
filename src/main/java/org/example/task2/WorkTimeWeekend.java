package org.example.task2;

import java.time.LocalDate;

public class WorkTimeWeekend {
    public static void main(String[] args) {

        LocalDate from = LocalDate.of(2019,3,1);
        LocalDate  to = LocalDate.of(2024,9,30);

        int sunday=0;
        int saturday=0;
        int allTimeWeekend=0;

        while(to.isAfter(from)){
            int dayOfMonth = from.getDayOfMonth();
            if (dayOfMonth==6){
                sunday++;
                allTimeWeekend = allTimeWeekend + 6;
            }else if (dayOfMonth==7){
                saturday++;
                allTimeWeekend = allTimeWeekend + 9;
            }
            from = from.plusDays(1);
        }

        System.out.println("allTimeWeekend = " + allTimeWeekend+ " hour.");


    }
}
