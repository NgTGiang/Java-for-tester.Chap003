package javafortester.chap016randomdata.example;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class RandomDataTest {
    private final Random generate = new Random();

    @Test
    public void canGenerateRandomInt(){
        int randomInt = generate.nextInt();

        System.out.println(randomInt);
        assertThat(randomInt < Integer.MAX_VALUE &&
                         randomInt >= Integer.MIN_VALUE,
                         is(true));
    }

    @Test
    public void canGenerateRandomBoolean(){
        int countTrue = 0;
        int countFalse = 0;

        for(int x = 0; x<1000; x++){
            boolean randomBoolean = generate.nextBoolean();
            if(randomBoolean){
                countTrue++;
            }else{
                countFalse++;
            }
        }

        System.out.printf("Generated %d as True%n", countTrue);
        System.out.printf("Generated %d as False%n", countFalse);

        assertThat(countTrue > 0, is(true));
        assertThat(countFalse > 0, is(true));
        assertThat(countFalse + countTrue, is(1000));
    }

    @Test
    public void canGenerateRandomLong(){
        long randomLong = generate.nextLong();

        System.out.println("Generate random Long: " + randomLong);
        assertThat(randomLong < Long.MAX_VALUE &&
                          randomLong >= Long.MIN_VALUE,
                         is(true));
    }

    @Test
    public void canGenerateRandomFloat(){
        float randomFloat = generate.nextFloat();

        System.out.println("Generate random float: " + randomFloat);
        assertThat(randomFloat < Float.MAX_VALUE &&
                          randomFloat >= Float.MIN_VALUE,
                          is(true));
    }

    @Test
    public void canGenerateRandomDouble(){
        double randomDouble = generate.nextDouble();

        System.out.println("Generate random double: "+ randomDouble);
        assertThat(randomDouble < Double.MAX_VALUE &&
                         randomDouble >= Double.MIN_VALUE,
                         is(true));
    }

    @Test
    public void canGenerateRandomBytes(){
        byte randomByte = (byte) generate.nextInt();

        System.out.println("Generate random byte: "+ randomByte);
        assertThat(randomByte < Byte.MAX_VALUE &&
                        randomByte >= Byte.MIN_VALUE,
                is(true));
    }

    @Test
    public void canGenerateRandomIntRange(){
        int randomIntRange = generate.nextInt(12);

        System.out.println("Generate random int range: "+ randomIntRange);
        assertThat(randomIntRange < 12 &&
                        randomIntRange >= 0,
                        is(true));
    }

    @Test
    public void canGenerate1000NumberBetween15And20(){
        int rangeMin = 15;
        int rangeMax = 20;
        int range = rangeMax - rangeMin + 1;

//    Create list of 1000 number between 15 and 20
        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i<1000; i++){
            int randomRange = generate.nextInt(range);
            intList.add(randomRange + rangeMin);
        }

//    Remove duplicate indexes
        List<Integer> listResult = new ArrayList<>();
        for (Integer integer : intList) {
            if (!listResult.contains(integer)) {
                listResult.add(integer);
            }
        }

        System.out.println(listResult);
    }

    @Test
    public void canGenerateRandomGaussianDistributionDouble(){
        int standardDeviationCount1 = 0;
        int standardDeviationCount2 = 0;
        int standardDeviationCount3 = 0;
        int standardDeviationCount4 = 0;

        for(int x=0; x<1000; x++){
            double randomGaussian = generate.nextGaussian();

            if(randomGaussian > -1.0d && randomGaussian < 1.0d)
                standardDeviationCount1++;
            if(randomGaussian > -2.0d && randomGaussian < 2.0d)
                standardDeviationCount2++;
            if(randomGaussian > -3.0d && randomGaussian < 3.0d)
                standardDeviationCount3++;
            if(randomGaussian > -4.0d && randomGaussian < 4.0d)
                standardDeviationCount4++;
        }

        float sd1percentage = (standardDeviationCount1/1000f) * 100f;
        System.out.println("about 70% one standard deviation = " + sd1percentage);

        float sd2percentage = (standardDeviationCount2/1000f) * 100f;
        System.out.println("about 95% two standard deviation = " + sd2percentage);

        float sd3percentage = (standardDeviationCount3/1000f) * 100f;
        System.out.println("about 99% three standard deviation = " + sd3percentage);

        float sd4percentage = (standardDeviationCount4/1000f) * 100f;
        System.out.println("about 99.9% four standard deviation = " + sd4percentage);

        assertTrue(sd1percentage < sd2percentage);
        assertTrue(sd2percentage < sd3percentage);
    }

    @Test
    public void canGenerate1000AgesUsingDeviation(){
        Map<Integer, Integer> ages = new HashMap<Integer, Integer>();

        for(int x=0; x<1000; x++){
            int age = (int)(generate.nextGaussian() * 5) + 35;
            int ageCount = 0;
            if(ages.containsKey(age)){
                ageCount = ages.get(age);
            }
            ageCount++;
            ages.put(age,ageCount);
        }
        SortedSet<Integer> agesSorted = new TreeSet(ages.keySet());
        for(int age : agesSorted){
            System.out.println(age + " : " + ages.get(age));
        }
    }

    @Test
    public void canGenerateRandomNumbersWithSeed(){
        for(int x=0; x<100; x++){
            Random generate = new Random(1234567L);
            assertThat(generate.nextInt() , is(1042961893));
            assertThat(generate.nextLong() , is(-6749250865724111202L));
            assertThat(generate.nextDouble() , is(0.44762832574617084D));
            assertThat(generate.nextGaussian() , is(-0.11571220872310763D));
            assertThat(generate.nextFloat() , is(0.33144182F));
            assertThat(generate.nextBoolean() , is(false));
        }
    }

    @Test
    public void canGenerateRandomString100Chars(){

    }

    @Test
    public void generateARandomString(){
        String validValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        StringBuilder rString = new StringBuilder();
        Random random = new Random();

        for(int x=0; x<100; x++){
            int rndIndex = random.nextInt(validValues.length());
            char rChar = validValues.charAt(rndIndex);
            rString.append(rChar);
        }
        System.out.println(rString.toString());

        assertTrue(rString.length()==100);
        assertTrue(rString.toString().matches("[A-Z ]+"));
    }
}
