package sawas;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter : ");
        String vvod = scan.nextLine();//принимает ввод строки
              String[] words = vvod.split(" ");//разделение и запись в массив строк, " " - разделитель
              if (words.length != 3){          //проверка на корректность выражения
                    System.out.print("throws Exception");
                    return;
              }
              String[] rim  = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
              int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
              int a = 0,b = 0;
              for(int i = 0; i < rim.length; i++)//находит в vvod римские цифры и присваивает им соотв-е арабские
              {
                    if(rim[i].equals(words[0]))
                    {
                        a = ar[i];
                    }
                    if(rim[i].equals(words[2]))
                    {
                        b = ar[i];
                    }
              }

              if(a != 0 & b != 0){ //работа с римскими
                    int Res = 0;
                    if (a > 10 | a < 1 | b > 10 | b < 1) {//условие на промежуток 1..10
                          System.out.print("throws Exception");
                    }else if (words[1].equals("+")){//определение и вычисление операции
                          Res = (a+b);
                    }else if (words[1].equals("-")){
                          if(a-b >= 0){ //условие не отрицательного числа
                                Res = (a-b);
                          }else System.out.print("throws Exception");
                    }else if (words[1].equals("*")){
                          Res = (a*b);
                    }else if (words[1].equals("/")){
                          Res = (a/b);
                    }else{
                          System.out.print("throws Exception");
                    }

                    //перевод Res обратно в римские
                    String Re ="";
                    if (Res < 1){
                          System.out.print("throws Exception");
                    }else if (Res > 99){
                          System.out.print("C");
                    }else if (Res > 89){
                          Re += "XC";
                          if (Res == 90){
                                System.out.print(Re);
                          }else System.out.print(Re + rim[Res - 91]);
                    }else if(Res > 49){
                          Re += "L";
                          Res -= 50;
                          if (Res == 0) {
                                System.out.print(Re);
                          }else if(Res > 39){
                                if(Res > 40) {
                                      System.out.print(Re + "XL" + rim[Res - 41]);
                                }else System.out.print(Re + "XL");
                          }else if(Res > 9){
                                int des = Res / 10;
                                for (int i = 0; i < des ;i++) Re += "X";
                                if(Res-des*10-1 > -1) {
                                      System.out.print(Re + rim[Res-des*10-1]);
                                }else System.out.print(Re);
                          }else{
                                System.out.print(Re + rim[Res-1]);
                          }
                    }else if(Res > 39){
                          if(Res > 40) {
                                System.out.print("XL" + rim[Res - 41]);
                          }else System.out.print("XL");
                    }else if(Res > 9){
                          int des = Res / 10;
                          for (int i = 0; i < des ;i++) Re += "X";
                          if(Res-des*10-1 > -1) {
                                System.out.print(Re+rim[Res-des*10-1]);
                          }else System.out.print(Re);
                    }else{
                          System.out.print(rim[Res-1]);
                    }


              }else if(a == 0 & b == 0){  //работа с арабскими
                    int aa = Integer.parseInt(words[0].trim());//перевод в тип int
                    int ba = Integer.parseInt(words[2].trim());
                    if (aa > 10 | aa < 1 | ba > 10 | ba < 1){//условие на промежуток 1..10
                          System.out.print("throws Exception");
                    }else if (words[1].equals("+")){//определение и вычисление операции
                          System.out.print(aa+ba);
                    }else if (words[1].equals("-")){
                          System.out.print(aa-ba);
                    }else if (words[1].equals("*")){
                          System.out.print(aa*ba);
                    }else if (words[1].equals("/")){
                          System.out.print(aa/ba);
                    }else{
                          System.out.print("throws Exception");
                    }
              } else System.out.print("throws Exception");
        }
}
