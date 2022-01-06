package javafortester.chap008selectionsanddecisions;

public class SwitchClass {

    public static String countrySwitch(String shortcode){
        String country;

        switch (shortcode.toLowerCase()){
            case "uk":
                country = "United Kingdom";
                break;

            case "us":
            case "usa":
                country = "United States";
                break;

            case "fr":
                country = "France";
                break;

            case "se":
                country = "Sweden";
                break;

            default:
                country = "Rest Of World";
        }
        System.out.println(country);
        return country;
    }

    public static String numberSwitch(int number){
        String result;

        if(number < 1){
            result = "Too small";
            System.out.println(result);

        } else if(number > 4){
            result = "Too big";
            System.out.println(result);

        } else{
            switch (number){
                case 1:
                    result = "One";
                    break;

                case 2:
                    result = "Two";
                    break;

                case 3:
                    result = "Three";
                    break;

                default:
                    result = "Four";
            }
            System.out.println(result);
        }
        return result;
    }
}
