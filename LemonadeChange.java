package interviewQA.GreedyAlgorithms;

public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills= {5,5,10,10,20};
        boolean res = lemonadeChange(bills);
        System.out.println(res);//false
    }
    public static boolean lemonadeChange(int[] bills) {
        int fivecount = 0;
        int tencount = 0;
        int n = bills.length;

        for(int i = 0; i <= bills.length-1; i++){
                if(bills[i] == 20){
                    if(tencount > 0 && fivecount > 0){
                        tencount--;
                        fivecount--;
                    }
                    else if(fivecount > 2){
                        fivecount = fivecount-3;
                    }
                    else{
                        return false;
                    }
                }else if(bills[i] == 10){
                    if (fivecount == 0)
                        return false;
                    fivecount--;
                    tencount++;
                }else if(bills[i] == 5) {
                    fivecount++;
                }
        }
        return true;
    }
}
