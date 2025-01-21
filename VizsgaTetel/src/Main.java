public class Main {
    public static void main(String[] args) {

        String[] couples = new String[2];
        int asztal = 1;
        int kapacitas = 1;

        try{
            couples[0]= args[0];
            couples[1]=args[1];
            asztal=Integer.parseInt(args[2]);
            kapacitas = Integer.parseInt(args[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (args.length == 0){
                couples[0]="Peter";
                couples[1]="Panna";
            }
            if (args.length <2){
                couples[1]="Panna";
            }
        }

        Eskuvo eskuvo = new Eskuvo(couples,asztal,kapacitas);

        new Frame(eskuvo);
    }
}