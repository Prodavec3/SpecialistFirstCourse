package lab1;

public class Lab13 {
    public static void main(String[] args) {
        System.out.println(getBinary(100));
    }

    private static String getBinary(int num){
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < 32; i++){
            stringBuilder.append(((num & 1) == 1) ? 1 : 0);
            num >>= 1;
            if (i == 7 || i == 15 || i == 23) stringBuilder.append(" ");
        }
        stringBuilder.reverse();

        return stringBuilder.toString();
    }
}
