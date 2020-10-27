public class main {


    public static void main(String[]  args ) {

        Mitarbeiter x = new Mitarbeiter("Walser", "Frank", 2, false, 1600.33);
        System.out.println(x.toString());

        Azubi y = new Azubi("Max", "Mueller", 1,true ,2300.50 ,21, "string");
        System.out.println(y.toString());

        System.out.println(y.weihnachtenPraemie());
        y.gehaltErhoehung(500);
        System.out.println(x.weihnachtenPraemie());

    }
}
