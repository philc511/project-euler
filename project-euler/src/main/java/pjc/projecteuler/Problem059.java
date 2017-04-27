package pjc.projecteuler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Project Euler Problem
 * Created by philc_000 on 18/04/2017.
 */
public class Problem059 {
    public static void main(String[] args) {
        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            Date startTime = new Date();
            (new Problem059()).solve("project-euler/src/main/resources/p059_cipher.txt");
            System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void solve(String filename) throws IOException{
        // get text as Character array
        File f = new File(filename);
        String line = Files.lines(f.toPath()).findFirst().get();
        List<Character> encrypted = Arrays.stream(line.split(",")).map(n -> (char) Integer.parseInt(n)).collect(Collectors.toList());

        // for each key:
        // get xored string and look for "the". Print if found
        for (char i = 97; i < 123; i++) {
            for (char j = 97; j < 123; j++) {
                for (char k = 97; k < 123; k++) {
                    List<Character> key = Arrays.asList(new Character[]{i,j,k});
                    String str= IntStream.range(0, encrypted.size())
                            .map(n -> (encrypted.get(n) ^ key.get(n%3)))
                            .collect(StringBuilder::new, (s, c) -> s.append((char)c), (s1,s2) -> s1.append(s2))
                            .toString();
                    if (str.contains("test")) {
                        System.out.printf("%c, %c, %c: %d: %s\n", i, j, k, str.chars().sum(), str);

                    }
                    List<Character> out = IntStream.range(0, encrypted.size()).boxed()
                            .map(n -> (char) (encrypted.get(n) ^ key.get(n%3)))
                            .collect(Collectors.toList());
                }
            }
        }
    }

    public List<Character> encrypt(String stringToEncrypt, String keyString)
    {
        List<Character> input = stringToEncrypt.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> key = keyString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        return xor(input, key);
    }

    private List<Character> xor(List<Character> encrypted, List<Character> key) {
        int keyLen = key.size();
        return IntStream.range(0, encrypted.size()).boxed()
                .map(n -> (char) (encrypted.get(n) ^ key.get(n%keyLen)))
                .collect(Collectors.toList());
    }

    public String decrypt(List<Character> decrypted, String keyString)
    {
        List<Character> key = keyString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> output = xor(decrypted, key);
        return output.stream().collect(StringBuilder::new, (s, c) -> s.append((char)c), (s1,s2) -> s1.append(s2))
                .toString();
    }
}
