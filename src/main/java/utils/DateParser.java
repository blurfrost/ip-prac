package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateParser {
    
    private static final DateTimeFormatter OUTPUT_FORMATTER = 
        DateTimeFormatter.ofPattern("dd MMM yyyy HHmm", Locale.ENGLISH);
    
    private static final String[] DAY_NAMES = {"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
    
    public static String parseDate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return input;
        }
        
        String trimmed = input.trim();
        
        String result = tryDayName(trimmed);
        if (result != null) {
            return result;
        }
        
        result = tryNumericDate(trimmed);
        if (result != null) {
            return result.toLowerCase(Locale.ENGLISH);
        }
        
        result = tryNamedMonthDate(trimmed);
        if (result != null) {
            return result.toLowerCase(Locale.ENGLISH);
        }
        
        return input;
    }
    
    private static String tryNumericDate(String input) {
        if (!input.contains("/") && !input.contains("-")) {
            return null;
        }
        
        String separator = input.contains("/") ? "/" : "-";
        
        try {
            String[] parts = input.split("\\s+");
            String datePart = parts[0];
            String timePart = parts.length > 1 ? parts[1] : "0000";
            
            String[] dateComponents = datePart.split("\\" + separator);
            if (dateComponents.length != 3) {
                return null;
            }
            
            int day = Integer.parseInt(dateComponents[0]);
            int month = Integer.parseInt(dateComponents[1]);
            int year = Integer.parseInt(dateComponents[2]);
            
            int hour = 0;
            int minute = 0;
            
            if (timePart.length() == 4) {
                hour = Integer.parseInt(timePart.substring(0, 2));
                minute = Integer.parseInt(timePart.substring(2, 4));
            }
            
            LocalDate date = LocalDate.of(year, month, day);
            LocalTime time = LocalTime.of(hour, minute);
            
            LocalDateTime dateTime = LocalDateTime.of(date, time);
            
            return dateTime.format(OUTPUT_FORMATTER);
        } catch (NumberFormatException | DateTimeParseException e) {
            return null;
        }
    }
    
    private static String tryNamedMonthDate(String input) {
        String[] monthNames = {"jan", "feb", "mar", "apr", "may", "jun", 
                               "jul", "aug", "sep", "oct", "nov", "dec"};
        
        String lowerInput = input.toLowerCase(Locale.ENGLISH);
        boolean hasMonthName = false;
        for (String month : monthNames) {
            if (lowerInput.contains(month)) {
                hasMonthName = true;
                break;
            }
        }
        if (!hasMonthName) {
            return null;
        }
        
        try {
            String[] parts = input.split("\\s+");
            
            int day = 0;
            int month = 0;
            int year = 0;
            String timePart = "0000";
            
            for (int i = 0; i < parts.length; i++) {
                String part = parts[i].toLowerCase(Locale.ENGLISH);
                
                if (isNumeric(part)) {
                    int value = Integer.parseInt(part);
                    if (part.length() == 4 && value >= 1900 && value <= 2100) {
                        year = value;
                    } else if (value >= 1 && value <= 31) {
                        day = value;
                    }
                } else {
                    month = parseMonth(part);
                    if (month == 0) {
                        return null;
                    }
                }
            }
            
            if (parts.length > 3) {
                String potentialTime = parts[parts.length - 1];
                if (potentialTime.length() == 4 && isNumeric(potentialTime)) {
                    int timeVal = Integer.parseInt(potentialTime);
                    int hour = timeVal / 100;
                    int minute = timeVal % 100;
                    if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
                        timePart = String.format("%04d", timeVal);
                    }
                }
            }
            
            LocalDate date = LocalDate.of(year, month, day);
            LocalTime time = LocalTime.of(
                Integer.parseInt(timePart.substring(0, 2)),
                Integer.parseInt(timePart.substring(2, 4))
            );
            
            LocalDateTime dateTime = LocalDateTime.of(date, time);
            
            return dateTime.format(OUTPUT_FORMATTER);
        } catch (NumberFormatException | DateTimeParseException e) {
            return null;
        }
    }
    
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static int parseMonth(String month) {
        String[] months = {"jan", "feb", "mar", "apr", "may", "jun", 
                          "jul", "aug", "sep", "oct", "nov", "dec"};
        for (int i = 0; i < months.length; i++) {
            if (month.startsWith(months[i])) {
                return i + 1;
            }
        }
        return 0;
    }
    
    private static String tryDayName(String input) {
        String lowerInput = input.toLowerCase(Locale.ENGLISH);
        
        int dayOfWeekIndex = -1;
        int matchLength = 0;
        
        String[] fullDayNames = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        
        for (int i = 0; i < fullDayNames.length; i++) {
            String dayName = DAY_NAMES[i];
            String fullDayName = fullDayNames[i];
            
            if (lowerInput.equals(dayName)) {
                dayOfWeekIndex = i;
                matchLength = dayName.length();
                break;
            }
            
            if (lowerInput.equals(fullDayName)) {
                dayOfWeekIndex = i;
                matchLength = fullDayName.length();
                break;
            }
            
            if (lowerInput.startsWith(dayName)) {
                int remainingLength = lowerInput.length() - dayName.length();
                if (remainingLength == 0) {
                    dayOfWeekIndex = i;
                    matchLength = dayName.length();
                    break;
                }
                
                char nextChar = lowerInput.charAt(dayName.length());
                if (nextChar == ' ' || !Character.isLetter(nextChar)) {
                    dayOfWeekIndex = i;
                    matchLength = dayName.length();
                    break;
                }
            }
            
            if (lowerInput.startsWith(fullDayName)) {
                int remainingLength = lowerInput.length() - fullDayName.length();
                if (remainingLength == 0) {
                    dayOfWeekIndex = i;
                    matchLength = fullDayName.length();
                    break;
                }
                
                char nextChar = lowerInput.charAt(fullDayName.length());
                if (nextChar == ' ' || !Character.isLetter(nextChar)) {
                    dayOfWeekIndex = i;
                    matchLength = fullDayName.length();
                    break;
                }
            }
        }
        
        if (dayOfWeekIndex == -1) {
            return null;
        }
        
        try {
            DayOfWeek inputDay = DayOfWeek.of(dayOfWeekIndex + 1);
            LocalDate today = LocalDate.now();
            
            int currentDayOfWeek = today.getDayOfWeek().getValue();
            int daysUntilNext = (inputDay.getValue() - currentDayOfWeek + 7) % 7;
            if (daysUntilNext == 0) {
                daysUntilNext = 7;
            }
            
            LocalDate nextOccurrence = today.plusDays(daysUntilNext);
            
            String timePart = "0000";
            String timeStr = input.substring(matchLength).trim();
            
            if (!timeStr.isEmpty()) {
                String[] timeParts = timeStr.split("\\s+");
                String potentialTime = timeParts[0];
                if (potentialTime.length() == 4 && isNumeric(potentialTime)) {
                    int timeVal = Integer.parseInt(potentialTime);
                    int hour = timeVal / 100;
                    int minute = timeVal % 100;
                    if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
                        timePart = String.format("%04d", timeVal);
                    }
                }
            }
            
            LocalTime time = LocalTime.of(
                Integer.parseInt(timePart.substring(0, 2)),
                Integer.parseInt(timePart.substring(2, 4))
            );
            
            LocalDateTime dateTime = LocalDateTime.of(nextOccurrence, time);
            
            return dateTime.format(OUTPUT_FORMATTER).toLowerCase(Locale.ENGLISH);
        } catch (NumberFormatException | DateTimeParseException e) {
            return null;
        }
    }
    
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println("Input: " + arg + " -> Output: " + parseDate(arg));
        }
    }
}
