package me.grovre.randomfacts;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.io.InputStream;

public class Joker {
    public static void main(String[] args) throws UnirestException, IOException {
        String joke = getJoke();
        System.out.println(joke);
    }

    public static String getJoke() throws UnirestException, IOException {
        // Haha funny joke
        InputStream stream = Unirest.get("https://uselessfacts.jsph.pl/random.txt?language=en")
                .asString().getRawBody();
        StringBuilder j = new StringBuilder();

        // InputStream read
        int next;
        do {
            next = stream.read();
            j.append((char) next);
        } while (next != -1);

        // String manipulation

        return j.toString()
                .split("\n")[0]
                .substring(1)
                .trim();
    }
}
