package com.example;

import java.util.Random;

public class Joker {

    String[] jokes = {
            "I dreamt I was forced to eat a giant marshmallow. When I woke up, my pillow was gone.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "Oh darling, since you've started dieting, you've become such a passionate kisser...\n" +
            "What do you mean, passionate? I'm looking for food remains!\n",
            "Doctor: Hello, did you come to see me with an eye problem?\n" +
            "Patient: Wow, yes, how can you tell?\n" +
            "Doctor: Because you came in through the window instead of the door."};

    public String getJoke(int jokeIndex) {
        return jokes[jokeIndex];
    }

    public int getJokesCount(){
        return jokes.length;
    }
}
