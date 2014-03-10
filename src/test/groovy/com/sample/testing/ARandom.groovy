package com.sample.testing;

import org.fluttercode.datafactory.impl.DataFactory;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

// TODO: Convert this class fully to groovy and clean it up.
public class ARandom {
    public static DataFactory df = new DataFactory();

    // Text Methods.
    public static String textContaining( String includeText, int length ) {
        int includeLength = includeText.length();
        if (includeLength > length)
            throw new RuntimeException("include text was greater than max length");
        if (includeLength == length)
            return includeText;
        int randomTextLength = length - includeLength;
        int leftRandomTextLength = ARandom.intBetween(0,randomTextLength);
        String leftRandomText = df.getRandomText(leftRandomTextLength);
        String rightRandomText = df.getRandomText(randomTextLength - leftRandomTextLength);
        return leftRandomText + includeText + rightRandomText;
    }

    // Date Methods.

    public static LocalDate dateInPastNumberOfDays( int days ){
        LocalDate minDate = DateTime.now().minusDays( days ).toLocalDate();
        return dateBetween( minDate, LocalDate.now() );
    }

    static LocalDate dateInPastMonth(){
        return dateInPastNumberOfDays(30)
    }

    public static LocalDate dateBetween( LocalDate min, LocalDate max ) {
        Days daysBetween = Days.daysBetween(min,max.plusDays( 1 )); // adding 1 day so end is inclusive.
        int numDays = daysBetween.getDays();
        int randomDays = intBetween(0,numDays);
        return min.plusDays( randomDays );
    }


    // Age & Birthdate Methods.

    public static int age(){
        return intBetween( 1, 100 );
    }

    public static int adultAge(){
        return intBetween( 21, 65 );
    }

    public static LocalDate birthDate(){
        Date birthDate = df.getBirthDate();
        return LocalDate.fromDateFields( birthDate );
    }

    public static LocalDate birthDateForAge(int age){
        LocalDate latestPossibleBirthday = LocalDate.now().minusYears( age );
        LocalDate earliestPossibleBirthday = LocalDate.now().minusYears( age + 1).plusDays(1); // Without this extra day, would be too old.
        return dateBetween( earliestPossibleBirthday, latestPossibleBirthday );
    }


    // Locations & Addresses.

    public static String stateCode() {
        return df.getItem( RandomData.stateCodes );
    }

    public static String zipcode5() {
        return df.getNumberText( 5 );
    }


    // Contact Info.

    public static String phoneUsa(){
        return df.getNumberText(3) + "-" + df.getNumberText(3) + "-" + df.getNumberText(4);
    }

    public static String email() {
        return df.getEmailAddress();
    }


    // Currency Methods.

    public static BigDecimal currencyAmount(){
        return new BigDecimal(intBetween( 0,99999999 ) + ( intBetween( 0,100 ) / 100.00 ) ).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public static BigDecimal currencyAmountLessThan( int maxAmount ){
        return new BigDecimal(intBetween( 0,maxAmount - 1 ) + ( intBetween( 0,100 ) / 100.00 ) ).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public static BigDecimal currencyAmountBetween( int minAmount, int maxAmount ){
        return new BigDecimal(intBetween( minAmount, maxAmount - 1 ) + ( intBetween( 0,100 ) / 100.00 ) ).setScale(2, BigDecimal.ROUND_CEILING);
    }

    public static BigDecimal interestRate(){
        return new BigDecimal( intBetween( 100,900 ) / 10000.00 ).setScale(6, BigDecimal.ROUND_CEILING);
    }


    // Names.

    public static String fullName(){
        return df.getFirstName() + " " + (df.getRandomChar() + " ").toUpperCase() + df.getLastName();
    }

    static String firstName() {
        return df.getFirstName()
    }

    static String lastName() {
        return df.getLastName()
    }

    static String text(int length) {
        return df.getRandomText(length)
    }


    // Other.

    public static int intBetween( int min, int max ){
        return df.getNumberBetween( min, max );
    }

    public static String ssn(){
        return df.getNumberText(3) + "-" + df.getNumberText(2) + "-" + df.getNumberText(4);
    }

    public static boolean percentChance( int percentChanceOfTrue ){
        return df.chance( percentChanceOfTrue );
    }

    public static <T> T itemFrom( List<T> items ) {
        return df.getItem( items );
    }

    public static String businessName() {
        return df.getBusinessName();
    }
}
