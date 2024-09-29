/**
 * Last Modified: 9/16/2024
 * Name: Tianxiang Huang
 * Test: No Test Yet
 * 
 */
public class Profile implements Comparable<Profile>{
    private String FirstName;
    private String LastName;
    private Date DateOfBirth;

    //constructor
    public Profile(){
        FirstName = "";
        LastName = "";
        DateOfBirth = null;
    }
    public Profile(String fn, String ln, Date DoB){
        FirstName = fn;
        LastName = ln;
        DateOfBirth = new Date(DoB.getMonth(), DoB.getDay(), DoB.getYear());
    }
    public Profile(String fn, String ln, int m, int d, int y){
        FirstName = fn;
        LastName = ln;
        DateOfBirth = new Date(m, d, y);
    }
    public Profile(Profile pa){
        FirstName = pa.getFirstName();
        LastName = pa.getLastName();
        DateOfBirth = new Date(pa.getBirthDay());
    }

    //get information
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public Date getBirthDay(){
        return DateOfBirth;
    }
    
    //Override
    @Override public int compareTo(Profile TargetProfile){
        return this.toString().compareTo(TargetProfile.toString());
    }
    @Override public String toString(){
        String result = "";
        result += FirstName.toLowerCase() + " " + LastName.toLowerCase() + " " + DateOfBirth.toString();
        result.toLowerCase();
        return result;
    }
    @Override public boolean equals(Object other){
        Profile TargetProfile = (Profile)other;
        if(TargetProfile.getFirstName().equals(this.getFirstName()) && TargetProfile.getLastName().equals(this.getLastName()) && this.DateOfBirth.equals(TargetProfile.getBirthDay())){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // Create Date instances for testing (assuming Date has a constructor Date(month, day, year))
        Date dob1 = new Date(1, 1, 1990);
        Date dob2 = new Date(1, 1, 1990);
        Date dob3 = new Date(1, 1, 1985);
        Date dob4 = new Date(1, 1, 1995);

        // Test case 1: Comparing profiles by last name (Brown vs. Smith)
        // Testing: Since "Brown" is lexicographically smaller than "Smith"
        Profile profile1 = new Profile("Alice", "Brown", dob1);
        Profile profile2 = new Profile("Bob", "Smith", dob2);
        System.out.println("Test case 1 (last name): " + profile1.compareTo(profile2)); // Expected: -1

        // Test case 2: Same last name, different first names (Alice vs. Bob)
        // Testing: Since the last names are the same, it compares the first names. "Alice" is lexicographically smaller than "Bob"
        Profile profile3 = new Profile("Alice", "Smith", dob1);
        Profile profile4 = new Profile("Bob", "Smith", dob2);
        System.out.println("Test case 2 (first name): " + profile3.compareTo(profile4)); // Expected: -1

        // Test case 3: Same first and last names, different date of birth (1985 vs. 1990)
        // Testing: Since both the last and first names are the same, it compares the date of birth. 1985 is earlier than 1990
        Profile profile5 = new Profile("Alice", "Smith", dob3);
        System.out.println("Test case 3 (earlier dob): " + profile5.compareTo(profile3)); // Expected: -1

        // Test case 4: Comparing profiles by last name (Smith vs. Brown)
        // Testing:  "Smith" is lexicographically greater than "Brown"
        Profile profile6 = new Profile("Bob", "Smith", dob1);
        System.out.println("Test case 4 (last name): " + profile6.compareTo(profile1)); // Expected: 1

        // Test case 5: Same last name, different first names (Bob vs. Alice)
        // Testing: Since the last names are the same, it compares the first names. Bob" is lexicographically greater than "Alice"
        Profile profile7 = new Profile("Bob", "Smith", dob1);
        Profile profile8 = new Profile("Alice", "Smith", dob1);
        System.out.println("Test case 5 (first name): " + profile7.compareTo(profile8)); // Expected: 1

        // Test case 6: Testing date of birth comparison.
        // Testing: Last name and first name are the same, so compare dates of birth. 1995 is later than 1990
        Profile profile9 = new Profile("Alice", "Smith", dob4);
        System.out.println("Test case 6 (later dob): " + profile9.compareTo(profile3)); // Expected: 1

        // Test case 7: Testing identical profiles.
        // Testing: Both last names, first names, and dates of birth are the same     
        Profile profile10 = new Profile("Alice", "Smith", dob1);
        Profile profile11 = new Profile("Alice", "Smith", dob1);
        System.out.println("Test case 7 (same profile): " + profile10.compareTo(profile11)); // Expected: 0
    }
}
