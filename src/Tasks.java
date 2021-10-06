import java.util.ArrayList;
import java.util.Comparator;

public class Tasks {
    public static void main(String[] args)  {
//1
    String[] ctities = new String[]{"Москва", "Санкт-Петербург", "Воронеж", "Зеленоград", "Солнечногорск"};
        System.out.println(arrayCities(ctities));

//2
        System.out.println(roundNumber((float) 41.7));
//3
        System.out.println(numberOfComputers(1048));
//4
        System.out.println(primeNumber(16));
//5     [7, 17, 1, 9, 1, 17, 56, 56, 23], [56, 17, 17, 1, 23, 34, 23, 1, 8, 1]

        ArrayList<Integer>  a = new ArrayList<>();
        a.add(7);
        a.add(17);
        a.add(1);
        a.add(9);
        a.add(1);
        a.add(17);
        a.add(56);
        a.add(56);
        a.add(23);
        ArrayList<Integer>  b = new ArrayList<>();
        b.add(56);
        b.add(17);
        b.add(17);
        b.add(1);
        b.add(23);
        b.add(34);
        b.add(23);
        b.add(1);
        b.add(8);
        b.add(1);
        ArrayList<Integer> res = manyMatchesInArrays(a,b);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }

    /*
   1.    Написать метод/функцию, который/которая на вход принимает массив городов.
    В качестве результата возвращает строку, где города разделены запятыми, а в конце стоит точка.
Пример:
«Москва, Санкт-Петербург, Воронеж.»
     */
    public static String arrayCities(String[] cities){
        String s = "";
        for(int i = 0; i < cities.length-1; i++){
            s+=(cities[i]+", ");
        }
        s = s+cities[cities.length-1]+".";
        return s;
    }
    /*
    2.      Написать метод/функцию, который/которая на вход принимает число (float), а на выходе получает число, округленное до пятерок.
Пример:
27 => 25, 27.8 => 30, 41.7 => 40.
     */
    public static int roundNumber(float num){
        int roundnum;
        if(num%5<2.5) {
            roundnum = ((int) (num / 5)) * 5;
        } else roundnum = ((int) (num / 5)) * 5 + 5;
        return roundnum;
    }
    /*
    3.      Написать метод/функцию, который/которая на вход принимает число (int),
    а на выходе выдает слово “компьютер” в падеже, соответствующем указанному количеству.
    Например, «25 компьютеров», «41 компьютер», «1048 компьютеров».
     */
    public static String numberOfComputers(int num){
        String form1 = " компьютер";
        String form2 = " компьютеров";
        String form3 = " компьютера";
        int d = num / 10 % 10;
        int l = num % 10;
        if(l==1) {return num+form1;}
        else if(d==1) {return num+form2;}
        else if(l>1&&l<5) {return num+form3;}
        else return num+form2;
    }
    /*
    4.      Написать метод/функцию, который/которая на вход принимает целое число,
     а на выходе возвращает то, является ли число простым (не имеет делителей кроме 1 и самого себя).
     */
    public static String primeNumber(int num){
        if (num%2==0 && num!=2) return "Не простое";
        for(int i=3;i*i<=num;i+=2) {
            if(num%i==0) return "Не простое";
        }
        return "Простое";
    }
    /*
    5.      Написать метод, который определяет, какие элементы присутствуют в двух экземплярах в каждом из массивов (= в двух и более, причем в каждом).
    На вход подаются два массива. На выходе массив с необходимыми совпадениями.
Пример:
[7, 17, 1, 9, 1, 17, 56, 56, 23], [56, 17, 17, 1, 23, 34, 23, 1, 8, 1]
На выходе [1, 17]
     */
    public static ArrayList manyMatchesInArrays(ArrayList<Integer> a, ArrayList<Integer> b){
        int countMatch = 0;
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                if(a.get(i) == a.get(j)) countMatch++;
            }
            if(countMatch<=1) a.remove(i);
            countMatch = 0;
        }
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if(b.get(i) == b.get(j)) countMatch++;
            }
            if(countMatch<=1) b.remove(i);
            countMatch = 0;
        }
            for (int j = 0; j < b.size(); j++) {
                if((a.contains(b.get(j))) && !(resultList.contains(b.get(j)))) resultList.add(b.get(j));
            }
        resultList.sort(Comparator.naturalOrder());
        return resultList;
    }
}
