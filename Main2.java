// практическая работа номер 3. Сортировки и определение одномерных массивов.
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
class Main2
{
    static int[] fillByHand ()
    {
        int size =0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        size=in.nextInt();
        int[] mass= new int[size];
        for (int i = 0; i<mass.length;i++)
        {
            System.out.println("Введите "+i+"-й элемент: ");
            mass[i]=in.nextInt();
        }
        return mass;
    }
    static int[] fillByRandom()
    {
        int size=0;
        int leftB,rightB;
        Scanner in= new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        size= in.nextInt();
        int [] mass = new int [size];
        System.out.println("Введите левую границу: ");
        leftB= in.nextInt();
        System.out.println("Введите правую границу: ");
        rightB=in.nextInt();
        Random rnd= new Random();
        for (int i = 0; i < mass.length; i ++)
        {
            mass[i]= rnd.nextInt(rightB-leftB)+leftB;
        }
        return mass;
    }
    static int [] BubbleSort(int [] mass){
        int buf = 0;
        boolean swap;
        int counter = 0;
        for (int i = 0; i < mass.length; i++) {
            counter=i+1;
            swap= false;
            for (int j = 1;j < (mass.length-i); j++) {
                if (mass[j-1]>mass[j])
                {
                    buf=mass[j];
                    mass[j]=mass[j-1];
                    mass[j-1]=buf;
                    swap= true;
                }
            }
            if (swap==false) {
                break;}
        }
        System.out.println("BubleSort - complete");
        return mass;
    }
    static void QuickSort(int [] mass, int left , int right){
        if (mass.length==0) {
            return;
        }
        if (left>=right) {
            return;
        }
        int mid= left +(right- left)/2;
        int op = mass[mid];
        int i= left, j=right;
        while(i<=j)
        {
            while (mass[i]<op){
                i++;
            }
            while(mass[j]>op){
                j--;
            }
            if (i<=j){
                int buf= mass[i];
                mass[i]=mass[j];
                mass[j]=buf;
                i++;
                j--;
            }
            if (left<j){
                QuickSort(mass,left,j);
            }
            if (right>i){
                QuickSort(mass,i,right);
            }
        }
    }

    public static void main(String[]args)
    {
        int ans,localans;
        int size=0;
        int [] mass = new int [0];
        Scanner in= new Scanner(System.in);
        do
        {
            System.out.println("1.Задать массив.");
            System.out.println("2.Задать рандомный массив.");
            System.out.println("3.Вывести массив в консоль. ");
            System.out.println("4.Сортировать массив. ");
            System.out.println("5.Решение задачи уровня B.");
            System.out.println("6.Решение задачи уровня С.");
            System.out.println("7.Выйти из меню.");
            System.out.print("Выберите пункт меню: ");
            ans = in.nextInt();
            switch (ans) {
                case 1:
                    mass = fillByHand();
                    System.out.println("Массив задан.");
                    break;
                case 2:
                    mass = fillByRandom();
                    System.out.println("Массив задан.");
                    break;
                case 3:
                    if (mass.length == 0)
                        System.out.println("Размер массива не может быть равен нулю.");
                    else {
                        System.out.println("Массив: ");
                        for (int i = 0; i < mass.length; i++) {
                            System.out.print(mass[i] + " ");
                        }
                        System.out.println();
                    }

                    break;
                case 4:
                    System.out.println("4.1. Сортировка в соответствии с вариантом 5.");
                    System.out.println("4.2. Быстрая сортировка.");
                    System.out.println("4.3. Сортировка встроенной функцией сортировки.");
                    System.out.println("4.4. Сравнение времени работы сортировок.");
                    System.out.print("выберите пункт меню: ");
                    localans= in.nextInt();
                    switch (localans) {
                        case 1:
                            long start = System.currentTimeMillis();
                            mass = BubbleSort(mass);
                            long end = System.currentTimeMillis();
                            long time = end - start;
                            System.out.println("SortTime=" + time);
                            break;
                        case 2:
                            long start1 = System.currentTimeMillis();
                            QuickSort(mass, 0, mass.length - 1);
                            long end1 = System.currentTimeMillis();
                            long time1 = end1 - start1;
                            System.out.println("SortTime=" + time1);
                            break;
                        case 3:
                            long start2 = System.currentTimeMillis();
                            Arrays.sort(mass);
                            long end2 = System.currentTimeMillis();
                            System.out.println("SortTime= " + (end2 - start2));
                            break;
                        case 4:
                            int[] mass1 = mass.clone();
                            int[] mass2 = mass.clone();
                            int[] mass3 = mass.clone();
                            long start1_case4 = System.currentTimeMillis();
                            mass1 = BubbleSort(mass1);
                            long end1_case4 = System.currentTimeMillis();
                            System.out.println("SortTime1=" + (end1_case4 - start1_case4));
                            long start2_case4 = System.currentTimeMillis();
                            QuickSort(mass, 0, mass.length - 1);
                            long end2_case4 = System.currentTimeMillis();
                            System.out.println("SortTime2=" + (end2_case4 - start2_case4));
                            long start3_case4 = System.currentTimeMillis();
                            Arrays.sort(mass3);
                            long end3_case4 = System.currentTimeMillis();
                            System.out.println("SortTime3=" + (end3_case4 - start3_case4));
                            break;
                        default:
                            System.out.println("Ошибка. \nНеобходимо выбрать один из 4 пунктов меню. ");
                    }
                    break;
                case 5:
                    int [] mass4= mass.clone();
                    mass4=BubbleSort(mass4);
                    int babyNum1=mass4[0] ;
                    int babyNum2=mass4[1];
                    int babyNum3=mass4[2];
                    System.out.println("sum= "+(babyNum1+babyNum2+babyNum3));
                    for (int i=0; i<=mass.length;i++){
                        if (mass[i]==babyNum1){
                            System.out.println("index1="+i);
                            break;
                        }
                    }
                    for (int z=0; z<=mass.length;z++) {
                        if (mass[z] == babyNum2) {
                            System.out.println("index2=" + z);
                            break;
                        }
                    }
                    for (int x=0; x<=mass.length;x++) {
                        if (mass[x] == babyNum3) {
                            System.out.println("index3=" + x);
                            break;
                        }
                    }

                    break;
                case 6:
                    int count =0;
                    int j=-1;
                    for (int i = 1; i<= mass.length-1;i++) {
                        j++;
                        if ((mass[i] % 2 != 0)&&(mass[j]%2!=0)){
                            if (mass[i]!=mass[j]){
                                count++;
                            }
                        }
                    }
                    System.out.println("count: "+count);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Ошибка. \nНеобходимо выбрать один из 7 пунктов меню. ");
            }
        }
        while (ans!=7);
    }
}