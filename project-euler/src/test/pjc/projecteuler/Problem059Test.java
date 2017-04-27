package pjc.projecteuler;

import org.junit.jupiter.api.Test;
import pjc.projecteuler.problems51to100.Problem059;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project Euler Problem
 * Created by philc_000 on 23/03/2017.
 */

public class Problem059Test {

    @Test
    public void testEncryptDecrypt()
    {
        Problem059 prob = new Problem059();
        String testStr = "Hello this is a test message 1, 2, 3. I hope it works okay!";
        String keyString = "abc";
        assertEquals(testStr, prob.decrypt(prob.encrypt(testStr, keyString), keyString));
    }

    @Test
    public void testGuessKey() throws IOException {
        Problem059 prob = new Problem059();
        String testStr = "Hello this is a test message 1, 2, 3. I hope it works okay!";
        String keyString = "yek";
        // this will output the encrypted string to a comma separated list of numbers
        //System.out.println(prob.encrypt(testStr, keyString).stream().map(c->"" +(int)c).collect(Collectors.joining(",")));
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        prob.solve("main/resources/p059_ciphertest.txt");
    }

}
