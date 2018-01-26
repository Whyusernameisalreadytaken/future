## Bigdecimal
### API intro
    Immutable, arbitrary-precision signed decimal numbers. 
    A BigDecimal consists of an arbitrary precision integer unscaled value and a 32-bit integer scale. 
    If zero or positive, the scale is the number of digits to the right of the decimal point. 
    If negative, the unscaled value of the number is multiplied by ten to the power of the negation of the scale. 
    The value of the number represented by the BigDecimal is therefore (unscaledValue × 10-scale).
### API note
1. Immutable means every operation to the bigdecimal object will return a new bigdecimal object,you must create a new 
pointer refer to this new object for latter use
```java
    String s = "1.23456";
    BigDecimal b = new BigDecimal(s);
    BigDecimal nb = b.setScale(4,RoundingMode.UP);
    System.out.println(b);//1.23456
    System.out.println(nb);//1.2345
```
2. Strong recommended that do not use constructor with double parameter
```java
    // not recommended
    double d = 1.23456D;
    System.out.println(d);//1.23456
    BigDecimal b = new BigDecimal(d);
    System.out.println(b);//1.2345600000000001017497197608463466167449951171875
    
    // use method below to get a exact arithmetic value
    BigDecimal z = new BigDecimal("1.23456");
    BigDecimal x = BigDecimal.valueOf(d);
    System.out.println(z);//1.23456
    System.out.println(x);//1.23456
```
3. Scale operation for Bigdecimal object:if use divide operation,you'd better set scale for the result object to avoid infinity decimal
```java
    BigDecimal devided = new BigDecimal("1.0");
    BigDecimal devisor = new BigDecimal("0.9");
    BigDecimal result = devided.divide(devisor);
    System.out.println(result);//java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
    BigDecimal result = devided.divide(devisor,4,RoundingMode.UP);//1.1112
```
4. Something important about double:when we save a double value like `double d = 0.99D;`,the arithmetic value loaded into memory is definitely
not 0.99.Just like the decimal system can not represent the exact value of `1/3`,binary system which uses digit 0 and 1 represent everything cannot tell a exact value of 0.99.
