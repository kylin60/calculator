package main.app.develop.test_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Random;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    public Button[] bt;
    public TextView txt1;
    public TextView txt2;
    private String  signal;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始一系列参数
        bt = new Button[16];

        // txt工作文本
        txt1 = (TextView) findViewById(R.id.text1);
        txt1.setText("");
        txt2 = (TextView) findViewById(R.id.text2);
        txt2.setText("");
        initial();
        Listeners();
    }

    // 每个按钮设置事件及监听
    private void initial() {
        bt[0] = (Button) findViewById(R.id.button0); //0
        bt[1] = (Button) findViewById(R.id.button1); //1
        bt[2] = (Button) findViewById(R.id.button2); //2
        bt[3] = (Button) findViewById(R.id.button3); //3
        bt[4] = (Button) findViewById(R.id.button4); //4
        bt[5] = (Button) findViewById(R.id.button5); //5
        bt[6] = (Button) findViewById(R.id.button6); //6
        bt[7] = (Button) findViewById(R.id.button7); //7
        bt[8] = (Button) findViewById(R.id.button8); //8
        bt[9] = (Button) findViewById(R.id.button9); //9
        bt[10] = (Button) findViewById(R.id.button_add);    // +
        bt[11] = (Button) findViewById(R.id.button_nadd);   // -
        bt[12] = (Button) findViewById(R.id.button_mul);    // *
        bt[13] = (Button) findViewById(R.id.button_sub);    // /
        bt[14] = (Button) findViewById(R.id.button_out);    // =
        bt[15] = (Button) findViewById(R.id.button_clear);  // Clear

        // 运算信号没有点击
        signal="#";
    }

    private void Listeners() {
        bt[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[0]));
            }
        });
        bt[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[1]));
            }
        });
        bt[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[2]));
            }
        });
        bt[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[3]));
            }
        });
        bt[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[4]));
            }
        });
        bt[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[5]));
            }
        });
        bt[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[6]));
            }
        });
        bt[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[7]));
            }
        });
        bt[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[8]));
            }
        });
        bt[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText(AddNumber(bt[9]));
            }
        });
        bt[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt1.getText().length() >= 1){
                    txt1.setText(AddSignal(bt[10]));
                }
            }
        });
        bt[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt1.getText().length() >= 1){
                    txt1.setText(AddSignal(bt[11]));
                }
            }
        });
        bt[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt1.getText().length() >= 1){
                    txt1.setText(AddSignal(bt[12]));
                }
            }
        });
        bt[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt1.getText().length() >= 1){
                    txt1.setText(AddSignal(bt[13]));
                }
            }
        });
        bt[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(signal != "#"){
                    // 空操作
                    ;
                }
                else {
                    Eval();
                    count=0;
                }
            }
        });
        bt[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               txt1.setText("");
               txt2.setText("");
               signal="#";
               count = 0;
            }
        });
    }

    // eval运算函数
    private void Eval() {
        String buffer=txt1.getText()+"";  String frontStr;
        String backStr="";                String ans="";

        // 找出运算符位置
        int index,num=0;

        // 前一个数，后一个数
        int f=0,b=0;
        if(buffer.indexOf('+')!=-1){
            index=buffer.indexOf('+');

            // 获取两个值
            frontStr=buffer.substring(0,index);
            backStr=buffer.substring(index+1,buffer.length());
            f = Integer.parseInt(frontStr);
            b = Integer.parseInt(backStr);

            //运算
            num=f+b;
            ans=String.valueOf(num);

            // 显示答案
            txt2.setText(ans);
            txt1.setText("");
        }
        else if(buffer.indexOf('-')!=-1){
            index=buffer.indexOf('-');

            // 获取两个值
            frontStr=buffer.substring(0,index);
            backStr=buffer.substring(index+1,buffer.length());
            f = Integer.parseInt(frontStr);
            b = Integer.parseInt(backStr);

            //运算
            num=f-b;
            ans=String.valueOf(num);

            // 显示答案
            txt2.setText(ans);
            txt1.setText("");
        }
        else if(buffer.indexOf('*')!=-1){
            index=buffer.indexOf('*');

            // 获取两个值
            frontStr=buffer.substring(0,index);
            backStr=buffer.substring(index+1,buffer.length());
            f = Integer.parseInt(frontStr);
            b = Integer.parseInt(backStr);

            //运算
            num=f*b;
            ans=String.valueOf(num);

            // 显示答案
            txt2.setText(ans);
            txt1.setText("");
        }
        else if(buffer.indexOf('/')!=-1){
            index=buffer.indexOf('/');

            // 获取两个值
            frontStr=buffer.substring(0,index);
            backStr=buffer.substring(index+1,buffer.length());
            f = Integer.parseInt(frontStr);
            b = Integer.parseInt(backStr);

            // 运算特殊情况分母为0
            if(b == 0){
                txt2.setText("无穷");
                txt1.setText("");
            }else{

                // 运算
                float _num=f/b;
                ans=String.valueOf(_num);

                // 显示
                txt2.setText(ans);
                txt1.setText("");
            }
        }
        else{
            // 显示
            txt2.setText(txt1.getText());
            txt1.setText("");
        }

    }

    // 子函数
    private void SubEval(){

    }

    // 加数字
    private String AddNumber(Button source) {

        // 每输入一个数字，运算信号置为#
        if( count == 7 && signal != "#"){
            signal = "#";
            count=1;
            return txt1.getText() + "" + source.getText();
        }
        else if( count > 1 && signal != "#"){
            signal = "#";
            count=1;
            return txt1.getText() + "" + source.getText();
        }
        else if(count>7){
            return txt1.getText()+"";
        }
        else {
            signal = "#";
            count++;
            return txt1.getText() + "" + source.getText();
        }
    }

    // 加运算符
    private String AddSignal(Button source) {
        if(signal != "#"){

            // 运算符变换
            int index = (""+txt1.getText()).indexOf(signal);
            signal = source.getText()+"";
            return (""+txt1.getText()).substring(0,index)+signal;
        }else if((txt1.getText()+"").length() == 0 &&
                 (txt2.getText()+"").length() > 0) {

            // 支持间接连运算（两个文本框）
            String temp;
            // 获取符号
            signal = source.getText() + "";
            temp=(txt2.getText()+"")+signal;
            // 置空文本2
            txt2.setText("");
            return temp;
        } else {

            // 只允许两个数进行运算
            if ((txt1.getText() + "").indexOf('+') != -1 ||
                    (txt1.getText() + "").indexOf('-') != -1 ||
                    (txt1.getText() + "").indexOf('/') != -1 ||
                    (txt1.getText() + "").indexOf('*') != -1
                    )
                return txt1.getText() + "";

            signal = source.getText() + "";
            return txt1.getText() + "" + source.getText();
        }
    }

}