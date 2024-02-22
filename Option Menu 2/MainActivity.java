package com.example.optionsmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    int square;
    TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem m1=menu.add(1,1,1,"Find Square");
        {
            m1.setAlphabeticShortcut('a');
        }
        menu.add(1,2,2,"Find Factorial");
        menu.add(1,3,3,"Check Palindrome");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        et1=findViewById(R.id.e1);
        tv1=findViewById(R.id.r1);
        int num=Integer.parseInt(et1.getText().toString());
        switch (item.getTitle().toString())
        {
            case "Find Square":
                square=num* num;
                tv1.setText("Square of "+num+" is "+square);
                Toast.makeText(getBaseContext(),"Susseccfully calculated Square",Toast.LENGTH_SHORT).show();

                break;
            case "Find Factorial":
                long fact=1;
                for (int i=1;i<=num;i++)
                {
                    fact=fact*i;
                }
                tv1.setText("Factorial of "+num+" is "+fact);
                Toast.makeText(getBaseContext(),"Susseccfully calculated Factorail",Toast.LENGTH_SHORT).show();
                break;

            case "Check Palindrome":
                int reverse=0;
                int original_num=num;

                while (num>0)
                {
                    int rem=num%10;
                    reverse=reverse*10+rem;
                    num=num/10;
                }

                if (original_num==reverse)
                {
                    tv1.setText(original_num+" is Palindrome number");
                }
                else{
                    tv1.setText(original_num+" is not palindrome Number");
                }
                Toast.makeText(getBaseContext(),"You Check Palindrome",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
