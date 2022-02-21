package javafortester.chap020mathandbigdecimal.example;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MathAndBigDecimalTest {

  @Test
  public void convinceYourselfOfBigDecimalOrInt(){
    double myDoubleMoney = 500 -30 -47 -173;
    System.out.println("My double have: " + myDoubleMoney);
    assertThat(myDoubleMoney, is(250.0));

    int myIntMoney = 500 -30 -47 -173;
    System.out.println("My int have: " + myIntMoney);
    assertThat(myIntMoney, is(250));

    BigDecimal myBDMoney = new BigDecimal("500")
                                .subtract(new BigDecimal("30"))
                                .subtract(new BigDecimal("47"))
                                .subtract(new BigDecimal("173"));
    System.out.println("My BigDecimal have: " + myBDMoney);
    assertThat(myBDMoney, is(new BigDecimal("250")));
  }

  @Test
  public void basicArithmeticWithBigDecimal(){
    BigDecimal aBigDecimal = new BigDecimal(0);
    aBigDecimal = aBigDecimal.add(BigDecimal.TEN);
    aBigDecimal = aBigDecimal.multiply(BigDecimal.valueOf(2));
    aBigDecimal = aBigDecimal.subtract(BigDecimal.TEN);
    aBigDecimal = aBigDecimal.divide(BigDecimal.valueOf(2));

    System.out.println("Value of 'aBigDecimal' is: "+aBigDecimal);
    assertThat(aBigDecimal, is(BigDecimal.valueOf(5)));
  }

  @Test
  public void compareTenAndOne(){
    BigDecimal one = BigDecimal.ONE;
    BigDecimal ten = BigDecimal.TEN;

    assertThat(ten.compareTo(one) >0, is(true));
    assertThat(ten.compareTo(one)>=0, is(true));
    assertThat(ten.compareTo(one)!=0, is(true));
    assertThat(one.compareTo(ten) <0, is(true));
    assertThat(one.compareTo(ten)<=0, is(true));
    assertThat(one.compareTo(one)==0, is(true));
  }
}
