package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.strictmode.ResourceMismatchViolation;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {
    int count=0;
    Button equals;
    Button b1, b0, b2, b3, b4, b5, b6, b7, b8, b9, bplus, bminus, bdivide, bmulti, bmodulo, bdot, bAC, bDel, bbracket;
    TextView History;
    TextView result;
    String number = "";
    Boolean del=false;
    int countequal=0;

    String numberbackup="";


    //digit
     boolean switchdigit =false;
   //operator
    boolean switchoperator=true;

    boolean operatorafterdot=false;

    int countoperator=0;
    int countoperand=0;


    boolean operator = false;
    boolean dot=true;
   DecimalFormat myformat=new DecimalFormat("######.#####");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b0 = findViewById(R.id.b0);
        b2 = findViewById(R.id.b2);
        b9 = findViewById(R.id.b9);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        bplus = findViewById(R.id.bplus);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        bminus = findViewById(R.id.bminus);
        bdivide = findViewById(R.id.bdivide);
        bmulti = findViewById(R.id.bmulti);
        bmodulo = findViewById(R.id.bModulo);
        bdot = findViewById(R.id.bdot);
        bAC = findViewById(R.id.bAC);
        bDel = findViewById(R.id.bDEL);

        equals = findViewById(R.id.bequals);
        History = findViewById(R.id.history);
        result = findViewById(R.id.result);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorafterdot=false;
                switchdigit =true;
                numberclick("0");
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);bmodulo.setClickable(true);
                bdot.setClickable(true);
                livecalculate();




            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchdigit =true;
                numberclick("1");
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);  bdot.setClickable(true);bmodulo.setClickable(true);
                operatorafterdot=false;

                livecalculate();




            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("2");
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);  bdot.setClickable(true);bmodulo.setClickable(true);
                operatorafterdot=false;
                switchdigit =true;
                livecalculate();



            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("3");
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);  bdot.setClickable(true);bmodulo.setClickable(true);

                operatorafterdot=false;
                switchdigit =true;
                livecalculate();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("4");
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);  bdot.setClickable(true);bmodulo.setClickable(true);

                operatorafterdot=false;
                switchdigit =true;
                livecalculate();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("5");
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);  bdot.setClickable(true);bmodulo.setClickable(true);
                operatorafterdot=false;


                switchdigit =true;
                livecalculate();

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("6");
                operatorafterdot=false;
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);  bdot.setClickable(true);bmodulo.setClickable(true);
                switchdigit =true;
                livecalculate();


            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorafterdot=false;
                numberclick("7");
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);  bdot.setClickable(true);bmodulo.setClickable(true);

                switchdigit =true;
                livecalculate();

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberclick("8");
                operatorafterdot=false;
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);  bdot.setClickable(true);bmodulo.setClickable(true);
                livecalculate();
                switchdigit =true;


            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livecalculate();
                numberclick("9");
                operatorafterdot=false;
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);bmodulo.setClickable(true);
                switchdigit =true;
            bdot.setClickable(true);
                switchdigit =true;


            }
        });


        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dot)
                {
                    operatorafterdot=true;
                }
                dot=true;

                numberclick("+");
                operator = false;
              switchoperator=true;
                switchdigit =false;
                bplus.setClickable(false);
                bminus.setClickable(false);bdivide.setClickable(false);bmulti.setClickable(false);  bdot.setClickable(true); bmodulo.setClickable(true);
                countequal=0;numberbackup="";



            }

        });


        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dot)
                {
                    operatorafterdot=true;
                }
                dot=true;
                switchoperator=true;
                numberclick("-");
                operator = false;
                switchdigit =false;
                bplus.setClickable(false);bminus.setClickable(false);bdivide.setClickable(false);bmulti.setClickable(false);  bdot.setClickable(true);bmodulo.setClickable(true);
                countequal=0;numberbackup="";



            }
        });
        bdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dot)
                {
                    operatorafterdot=true;
                }
                switchdigit =false;
                switchoperator=true;
                numberclick("/");
                operator = false;
                bplus.setClickable(false);
                bminus.setClickable(false);bdivide.setClickable(false);bmulti.setClickable(false);  bdot.setClickable(true);bmodulo.setClickable(true);
                countequal=0;
                dot=true;numberbackup="";


            }
        });
        bmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dot)
                {
                    operatorafterdot=true;
                }
               switchdigit =false;
                numberclick("*");
                operator = false;
                bplus.setClickable(false);
                bminus.setClickable(false);bdivide.setClickable(false);bmulti.setClickable(false);bmodulo.setClickable(true);
                bdot.setClickable(true);
                switchoperator=true;
                dot=true;
                countequal=0;numberbackup="";

            }
        });
        bmodulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),"One Operation Unabled Only",Toast.LENGTH_SHORT).show();

                if(!dot)
                {
                    operatorafterdot=true;
                }
                numberclick("%");
                switchdigit =false;
                switchoperator=true;
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);
                bdot.setClickable(true);
                bmodulo.setClickable(false);
                modcalculate(number);
                countequal=0;
                numberbackup="";

            }
        });


        bAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot=true;
                number="";
                History.setText("");
                result.setText("");
                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);bmodulo.setClickable(true);
                countequal=0;
                countoperator=0;
                countoperand=0;
                b0.setClickable(true);
                b1.setClickable(true);
                b2.setClickable(true);
                b3.setClickable(true);
                b4.setClickable(true);
                b5.setClickable(true);
                b6.setClickable(true);
                b7.setClickable(true);
                b8.setClickable(true);
                b9.setClickable(true);



            }
        });

        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(number.endsWith("+")||number.endsWith("-")||number.endsWith("*")||number.endsWith("/")||number.endsWith("%"))
               {
                   countoperator--;
                   bplus.setClickable(true);
                   bminus.setClickable(true);
                   bdivide.setClickable(true);
                   bmulti.setClickable(true);
                   bmodulo.setClickable(true);
               }
               else
               {
                   countoperand--;
                   b0.setClickable(true);
                   b1.setClickable(true);
                   b2.setClickable(true);
                   b3.setClickable(true);
                   b4.setClickable(true);
                   b5.setClickable(true);
                   b6.setClickable(true);
                   b7.setClickable(true);
                   b8.setClickable(true);
                   b9.setClickable(true);
               }


                countequal=0;

                dot=true;

                bplus.setClickable(true);
                bminus.setClickable(true);bdivide.setClickable(true);bmulti.setClickable(true);bmodulo.setClickable(true);
                String viewtext=History.getText().toString();
                if(viewtext==null&&number.length()<2)
                {
                    count=0;
                    bDel.setClickable(false);
                    History.setText("");
                    number="";
                    result.setText("");
                }
                else
                {
                    bDel.setClickable(true);
                    try
                    {
                            number = number.substring(0, number.length() - 1);
                            count--;
                            livedelcalculate(number);
                            History.setText(number);



                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        e.printStackTrace();
                    }

                }
                }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

               if(dot)
               {
                   numberclick(".");
               }
               dot=false;

            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                countoperand=0;
                countoperator=0;
                b0.setClickable(true);
                b1.setClickable(true);
                b2.setClickable(true);
                b3.setClickable(true);
                b4.setClickable(true);
                b5.setClickable(true);
                b6.setClickable(true);
                b7.setClickable(true);
                b8.setClickable(true);
                b9.setClickable(true);
                countequal++;
                bplus.setClickable(true);
                bminus.setClickable(true);
                bdivide.setClickable(true);
                bmulti.setClickable(true);
                bmodulo.setClickable(true);
                dot = true;
                if(countequal==1)
                {
                    equalclick1();
                }
                else
                {
                    equalclick2();
                }

            }
        });

    }
    public void equalclick1()
    {
        History.setText(result.getText().toString());
       number=result.getText().toString();
       conversion(number);
    }
    public void equalclick2()
    {
        try {
            int last_operator_index=0;
            for(int i=numberbackup.length()-1;i>=0;i--)
            {
                char ch=numberbackup.charAt(i);
                if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
                {
                    last_operator_index = i;



                }
            }
            String operator_last = String.valueOf(numberbackup.charAt(last_operator_index));
            int operand = Integer.parseInt(String.valueOf(numberbackup.substring(last_operator_index+1, numberbackup.length())));
            numberbackup = result.getText().toString() + operator_last + operand;
           conversion(numberbackup);
           number=result.getText().toString();
           History.setText(result.getText().toString());




        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
    }
    public void numberclick(String view)
    {
        if(view=="%")
        {

            b0.setClickable(false);
            b1.setClickable(false);
            b2.setClickable(false);
            b3.setClickable(false);
            b4.setClickable(false);
            b5.setClickable(false);
            b6.setClickable(false);
            b7.setClickable(false);
            b8.setClickable(false);
            b9.setClickable(false);
            bplus.setClickable(false);
            bmulti.setClickable(false);
            bminus.setClickable(false);
            bdivide.setClickable(false);
            bmodulo.setClickable(false);
        }

        if(view=="+"||view=="-"||view=="*"||view=="/")
        {
            countoperator++;
            b0.setClickable(true);
            b1.setClickable(true);
            b2.setClickable(true);
            b3.setClickable(true);
            b4.setClickable(true);
            b5.setClickable(true);
            b6.setClickable(true);
            b7.setClickable(true);
            b8.setClickable(true);
            b9.setClickable(true);
            if(countoperator>6)
            {
                Toast.makeText(this,"Max operators allowed = 7",Toast.LENGTH_SHORT).show();
                bplus.setClickable(false);
                bmulti.setClickable(false);
                bminus.setClickable(false);
                bdivide.setClickable(false);
                bmodulo.setClickable(false);

            }
            countoperand=0;
        }
        else
        {
            countoperand++;
            if(countoperand>7)
            {
                Toast.makeText(this,"Max Operand Size = 8",Toast.LENGTH_SHORT).show();
                b0.setClickable(false);
                b1.setClickable(false);
                b2.setClickable(false);
                b3.setClickable(false);
                b4.setClickable(false);
                b5.setClickable(false);
                b6.setClickable(false);
                b7.setClickable(false);
                b8.setClickable(false);
                b9.setClickable(false);

            }
        }

        countequal=0;


        count++;

            if (view == ".") {
                if (number.isEmpty()) {
                    number = "0" + view;


                } else if (switchdigit && switchoperator) {
                    number = number + view;


                } else if (switchoperator && !switchdigit) {
                    number = number + "0" + view;


                }
            }
            else if (number == null)
            {
                number = view;
            } else
            {
                number = number + view;

            }

            History.setText(number);
            System.out.println("History In numberclick function " +History.getText().toString());
            System.out.println("Number Backup variable value Number click function"+numberbackup);
            numberbackup=number;
            System.out.println("Number Backup variable value Number click function"+numberbackup);
        System.out.println("Number variable value Number click function"+number);
            del = false;
        }


        public void livecalculate()
        {
            conversion(number);

        }
        public void livedelcalculate(String numberequation)
        {
            if(numberequation.endsWith("+")||numberequation.endsWith("-")||numberequation.endsWith("*")||numberequation.endsWith("/")||numberequation.endsWith("%"))
            {

                bplus.setClickable(false);
                bdivide.setClickable(false);
                bminus.setClickable(false);
                bmulti.setClickable(false);
                bmodulo.setClickable(false);
            }

                conversion(numberequation);

        }
        public void modcalculate(String numberequation1)
        {

            conversion(numberequation1);
        }




    public void conversion(String equation)
    {
        if(equation.startsWith("+")||equation.startsWith("-")||equation.startsWith("*")||equation.startsWith("/")||equation.startsWith("%"))
        {
            Toast.makeText(this,"Invalid Operation",Toast.LENGTH_SHORT).show();
            equation="";
            number="";
        }
        ArrayList<String> newlist = new ArrayList<>();

        String equation1 = equation + " ";
        int count = 0;
        char ch;
        String number = "";
        for (int i = 0; i < equation1.length(); i++) {
            ch = equation1.charAt((i));
            System.out.println("Character extracted=" + ch);
            if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != equation1.charAt(equation1.length() - 1)&&ch!='%')
            {
                number = number + ch;


            }
            else
            {
                if(number!="")
                {
                    number = number.trim();
                    newlist.add(count, number);
                    count++;
                }
                number = "";
                newlist.add(count, String.valueOf(ch));
                count++;
            }
        }



        if(newlist.size()>15)
        {
            Toast.makeText(this,"Operations exceed 15",Toast.LENGTH_SHORT).show();
            b0.setClickable(false);
            b1.setClickable(false);
            b2.setClickable(false);
            b3.setClickable(false);
            b4.setClickable(false);
            b5.setClickable(false);
            b6.setClickable(false);
            b7.setClickable(false);
            b8.setClickable(false);
            b9.setClickable(false);
            bplus.setClickable(false);
            bmulti.setClickable(false);
            bminus.setClickable(false);
            bdivide.setClickable(false);
            bmodulo.setClickable(false);
            bdot.setClickable(false);
        }


            calculate(newlist);




    }

    public void calculate(ArrayList<String>newlist) {
        result.setText("");
        try {
            while(newlist.contains("%")==true) {
                if (newlist.contains("%")) {


                    String operator1;
                    double value1 = 0.0;
                    double numberbeforeper1 = 0.0;
                    double numberbeforeop1;
                    int operatorlocation1 = 0;
                    try {


                        operatorlocation1 = newlist.indexOf("%");
                        numberbeforeper1 = Double.valueOf(newlist.get(operatorlocation1 - 1));

                        operator1 = newlist.get(operatorlocation1 - 2);
                        if(value1==0.0)
                        {
                            numberbeforeop1 = Double.valueOf(newlist.get(operatorlocation1 - 3));
                        }
                        else
                        {
                            numberbeforeop1 = value1;
                        }

                    } catch (IndexOutOfBoundsException e)
                    {
                        numberbeforeop1 = 0.0;

                        value1=numberbeforeop1+(numberbeforeper1)/100;
                        newlist.set(operatorlocation1,String.valueOf(value1));
                        newlist.remove(operatorlocation1-1);
                        continue;
                    }
                    switch (operator1) {
                        case "+": {
                            value1 = numberbeforeop1 + ((numberbeforeop1 * numberbeforeper1 )/ 100);
                            break;

                        }

                        case "-": {
                            value1 = numberbeforeop1 - ((numberbeforeop1 * numberbeforeper1) / 100);
                            break;
                        }

                        case "*": {
                            value1 = numberbeforeop1 *( (numberbeforeop1 * numberbeforeper1) / 100);
                            break;

                        }

                        case "/": {
                            value1 = numberbeforeop1 / ((numberbeforeop1 * numberbeforeper1 )/ 100);
                            break;

                        }


                        default:
                        {
                            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    try {
                        newlist.set(operatorlocation1, String.valueOf(value1));

                        newlist.remove(operatorlocation1 - 1);

                        newlist.remove(operatorlocation1 - 2);


                        newlist.remove(operatorlocation1 - 3);


                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }

                }
            }


            while (newlist.contains("/") == true) {
                if (newlist.contains("/")) {
                    int operatorlocation = newlist.indexOf("/");
                    double number1 = Double.valueOf(newlist.get(operatorlocation - 1));
                    System.out.println(number1);
                    double number2 = Double.valueOf(newlist.get(operatorlocation + 1));
                    System.out.println(number2);
                    double value = number1 / number2;
                    System.out.println("value" + value);
                    newlist.remove(operatorlocation - 1);
                    newlist.set(operatorlocation - 1, String.valueOf(value));
                    newlist.remove(operatorlocation);
                    //newlist.set(operatorlocation,String.valueOf(value));
                    //  newlist.remove(operatorlocation-1);
                    //  newlist.remove(operatorlocation);
                }
            }

            while (newlist.contains("*") == true) {
                if (newlist.contains("*")) {
                    int operatorlocation = newlist.indexOf("*");
                    double number1 = Double.valueOf(newlist.get(operatorlocation - 1));
                    System.out.println(number1);
                    double number2 = Double.valueOf(newlist.get(operatorlocation + 1));
                    System.out.println(number2);
                    double value = number1 * number2;
                    System.out.println("value" + value);
                    newlist.remove(operatorlocation - 1);
                    newlist.set(operatorlocation - 1, String.valueOf(value));
                    newlist.remove(operatorlocation);
                    //newlist.set(operatorlocation,String.valueOf(value));
                    // newlist.remove(operatorlocation-1);
                    //  newlist.remove(operatorlocation);
                }
            }
            while (newlist.contains("+") == true) {
                if (newlist.contains("+")) {
                    int operatorlocation = newlist.indexOf("+");
                    double number1 = Double.valueOf(newlist.get(operatorlocation - 1));
                    System.out.println(number1);
                    double number2 = Double.valueOf(newlist.get(operatorlocation + 1));
                    System.out.println(number2);
                    double value = number1 + number2;
                    System.out.println("value" + value);
                    newlist.remove(operatorlocation - 1);
                    newlist.set(operatorlocation - 1, String.valueOf(value));
                    newlist.remove(operatorlocation);
                }
            }
            while (newlist.contains("-") == true) {
                if (newlist.contains("-")) {
                    int operatorlocation = newlist.indexOf("-");
                    double number1 = Double.valueOf(newlist.get(operatorlocation - 1));
                    System.out.println(number1);
                    double number2 = Double.valueOf(newlist.get(operatorlocation + 1));
                    System.out.println(number2);
                    double value = number1 - number2;
                    System.out.println("value" + value);
                    newlist.remove(operatorlocation - 1);
                    newlist.set(operatorlocation - 1, String.valueOf(value));
                    newlist.remove(operatorlocation);
                    // newlist.set(operatorlocation,String.valueOf(value));
                    //newlist.remove(operatorlocation-1);
                    //newlist.remove(operatorlocation);
                }
            }
            if(count>=2)
            {
                double result1 = Double.valueOf(newlist.get(0));
                newlist.clear();
                result.setText(myformat.format(result1));
            }

        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }

    }

}











































