package com.example.random_quotes;

import static java.lang.String.valueOf;
import static kotlin.text.Typography.quote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {


    String[] randomTexts = {
            "You will face many defeats in life, but never let yourself be defeated. – Maya Angelou",
            "In three words I can sum up everything I've learned about life: It goes on. – Robert Frost",
            "Life is a long lesson in humility. – J.M. Barrie",
            "To live is the rarest thing in the world. Most people exist, that is all. – Oscar Wilde",
            "The most important thing is to enjoy your life–to be happy–it's all that matters. – Audrey Hepburn",
            "To succeed in life, you need three things: a wishbone, a backbone and a funnybone. – Reba McEntire",
            "We must be willing to let go of the life we planned so as to have the life that is waiting for us. – Joseph Campbell",
            "Life is a succession of lessons which must be lived to be understood. – Ralph Waldo Emerson",
            "Love the life you live. Live the life you love. – Bob Marley",
            "I was taught that the way of progress was neither swift nor easy. – Marie Curie",
            "He who has a why to live for can bear almost any how. – Friedrich Nietzsche",
            "You only live once, but if you do it right, once is enough. – Mae West",
            "The whole secret of a successful life is to find out what is one's destiny to do, and then do it. – Henry Ford",
            "In order to write about life first you must live it. – Ernest Hemingway",
            "Life has no limitations, except the ones you make. – Les Brown",
            "It's your outlook on life that counts. If you take yourself lightly and don't take yourself too seriously, pretty soon you can find the humor in our everyday lives. And sometimes it can be a lifesaver. – Betty White",
            "Live for each second without hesitation. – Elton John",
            "The most wasted of all days is one without laughter. – E. E. Cummings",
            "Start each day with a positive thought and a grateful heart. – Roy Bennett",
            "All you need in this life is ignorance and confidence; then success is sure. – Mark Twain",
            "I believe that if you'll just stand up and go, life will open up for you. Something just motivates you to keep moving. – Tina Turner",
            "Many of life's failures are people who did not realize how close they were to success when they gave up. – Thomas Edison",
            "I have very strong feelings about how you lead your life. You always look ahead, you never look back. – Ann Richards",
            "Life is like riding a bicycle. To keep your balance, you must keep moving. – Albert Einstein",
            "Life shrinks or expands in proportion to one's courage. – Anais Nin",
            "You do not find the happy life. You make it. – Camilla Eyring Kimball",
            "A life is not important except in the impact it has on other lives. – Jackie Robinson",
            "The purpose of life is to live it, to taste experience to the utmost, to reach out eagerly and without fear for newer and richer experience. – Eleanor Roosevelt",
            "The biggest adventure you can ever take is to live the life of your dreams. – Oprah Winfrey",
            "If you own this story you get to write the ending. – Brené Brown",
            "Life is like a coin. You can spend it any way you wish, but you only spend it once. – Lillian Dickinson",
            "Life is about making an impact, not making an income. – Kevin Kruse",
            "There are no regrets in life, just lessons. – Jennifer Aniston",
            "Accept no one's definition of your life, define yourself. – Harvey Fierstein",
            "The longer I live the more beautiful life becomes. – Frank Lloyd Wright",
            "If you love life, don't waste time, for time is what life is made up of. – Bruce Lee",
            "Mistakes are a fact of life. It is the response to the error that counts. – Nikki Giovanni",
            "Life is not a problem to be solved, but a reality to be experienced. – Soren Kierkegaard",
            "Your time is limited, so don't waste it living someone else's life. – Steve Jobs",
            "If everything was perfect, you would never learn and you would never grow. – Beyoncé",
            "If we don't change, we don't grow. If we don't grow, we aren't really living. – Gail Sheehy",
            "I have learned that success is to be measured not so much by the position that one has reached in life as by the obstacles which he has overcome while trying to succeed. – Booker T. Washington"
    };

    private Button gen;
    private TextView tv, tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        HashMap<String, String> quoteDictionary = new HashMap<>();

        for (String text : randomTexts) {
            String[] parts = text.split(" – ");
            if (parts.length == 2) {
                String quote = parts[0].trim();
                String author = parts[1].trim();
                quoteDictionary.put(quote, author);
            }

            gen = findViewById(R.id.btn2);
            tv = findViewById(R.id.txtvv);
            tv2 = findViewById(R.id.txtvv2);
            tv3 = findViewById(R.id.txtx);
            gen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    ArrayList<String> quotesList = new ArrayList<>(quoteDictionary.keySet());
                    Random random = new Random();
                    int randomIndex = random.nextInt(quotesList.size());
                    String randomQuote = quotesList.get(randomIndex);
                    String author = quoteDictionary.get(randomQuote);
                    tv.setText(randomQuote);
                    tv2.setText(author);
                    tv3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String fullText = randomQuote + "\n" + "https://github.com/Kuldeep189/CodeAlpha_Random_quote";
                            Intent ineet = new Intent(Intent.ACTION_SEND);
                            ineet.setType("text/plain");
                            ineet.putExtra(Intent.EXTRA_SUBJECT,"Quote for the day");
                            ineet.putExtra(Intent.EXTRA_TEXT,valueOf(fullText));
                            startActivity(Intent.createChooser(ineet, "Share via"));
                        }
                    });
                }
            });

        }
    }
}
