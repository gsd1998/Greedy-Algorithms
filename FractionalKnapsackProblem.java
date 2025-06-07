package interviewQA.GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {

    public static void main(String[] args)
    {
        int n = 3, weight = 50;
        Item[] arr = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);//240
    }

    private static double fractionalKnapsack(int weight, Item[] arr, int n) {
        double total = 0.0;
        CustomComp comp = new CustomComp();
        Arrays.sort(arr,comp);
        for(int i = 0; i <= n-1; i++){
            if(weight >= arr[i].weight){
                weight = weight - arr[i].weight;
                total = total + arr[i].val;
            }else{
                double w = (double)arr[i].weight;
                double v = (double)arr[i].val;
                total = total + (v/w) * (double)weight;
                break;
            }
        }
        return total;
    }
}

class CustomComp implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        double a = (double)o1.val/(double)o1.weight;
        double b = (double)o2.val/(double)o2.weight;
        if(a > b){
            return -1;
        }else if(a < b){
            return 1;
        }
        else return 0;
    }
}

class Item{
    int weight;
    int val;
    Item(int val, int weight){
        this.val = val;
        this.weight = weight;
    }
}
