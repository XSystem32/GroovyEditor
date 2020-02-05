package com.company;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestIP {

    private IPAdressValidator ipAdressValidator;

    @BeforeClass
    public void initData() {
         ipAdressValidator = new IPAdressValidator();
    }

    @DataProvider
    public Object[][] ValidIpAddress() {
        return new Object[][] {
                new Object[] {"12\\\\.45\\\\.12\\\\.55"}, new Object[] {"(185\\\\.59\\\\.(?:1(?:0[6-7]))\\\\.(?:[0-9]|[1-9][0-9]|1(?:[0-9][0-9])|2(?:[0-4][0-9]|5[0-5])))"},
                new Object[] {"105\\\\.233\\\\.132\\\\.194"}, new Object[] {"152\\\\.115\\\\.44\\\\.([1-9]|1[0-4])"},
                new Object[] {"182\\\\.232\\\\.140\\\\.[0-9]|[1-9][0-9]|1([0-9][0-9])|2([0-4][0-9]|5[0-5]))"}, new Object[] {"213\\\\.83\\\\.149\\\\.250,185\\\\.81\\\\.116\\\\.10"},
                new Object[] {"15\\\\.199\\\\.59\\\\.(15-5)"}, new Object[] {"185\\\\.16\\\\.(1(5[6-9]))\\\\.([0-9]|[1-9][0-9]|1([0-9][0-9])|2([0-4][0-9]|5[0-5]))"},
                new Object[] {"185\\\\.(6(1[7-1]))\\\\.(1(5[6-9]))\\\\.([0-9]|[1-9][0-9]|1([0-9][0-9])|2([0-4][0-9]|5[0-5]))"},
                new Object[] {"185\\\\.(6(1[7-1]))\\\\.(1(5[6-9]))\\\\.154"},
                new Object[] {"185\\\\.(6(1[7-1]))\\\\.56\\\\.([0-9]|[1-9][0-9]|1([0-9][0-9])|2([0-4][0-9]|5[0-5]))"},
                new Object[] {"185\\\\.(6(1[7-1]))\\\\.74\\\\.22"}

        };
    }

    @DataProvider
    public Object[][] InvalidIpAddress() {
        return new Object[][] {
                new Object[] {"bg\\\\.233\\\\.132\\\\.194"}, new Object[] {"194\\\\.233\\\\.132\\\\.bg"},
                new Object[] {"233\\\\.bg\\\\.132\\\\.194"}, new Object[] {"132\\\\.233\\\\.bg\\\\.194"},
                new Object[] {"aa\\\\bb\\\\.dd\\\\.cc"}, new Object[] {"12\\\\.cc\\\\.dd\\\\.55"},
                new Object[] {"aa\\\\bb\\\\.12\\\\.55"}, new Object[] {"aa\\\\.45\\\\.12\\\\.bb"}, new Object[] {"105\\.233\\.132\\.194"},
                new Object[] {"12\\\\45\\\\.dd\\\\.cc"}, new Object[] {"\\\\.\\\\.\\\\."}, new Object[] {"105\\.233\\.132\\.194"},
                new Object[] {"(185\\.59\\.(?:1(?:0[6-7]))\\.(?:[0-9]|[1-9][0-9]|1(?:[0-9][0-9])|2(?:[0-4][0-9]|5[0-5])))"},
                new Object[] {"(185\\.59\\.(?:1(?:0[6-7]))\\.(?:[0-b]|[b-9][0-9a]|1(?:[0-9][0-9])|2(?:[0-4][0-9]|5[0-5])))"},
                new Object[] {"12\\.45\\\\.12\\.55"},new Object[] {"12\\\\.45\\\\12\\\\.55"},
                new Object[] {"12\\.45\\12\\.55"}
        };
    }



    @Test(dataProvider = "ValidIpAddress")
    public void ValidIpAddressTest(String ip) {
        boolean valid = ipAdressValidator.valide(ip);
        System.out.println("IPAddress is valid : " + ip + " , " + valid);
        Assert.assertTrue(valid);
    }

    @Test(dataProvider = "InvalidIpAddress")
    public void InvalidIpAddressTest(String ip) {
        boolean valid = ipAdressValidator.valide(ip);
        System.out.println("IPAddress is invalid : " + ip + " , " + valid);
        Assert.assertFalse(valid);
    }


}
