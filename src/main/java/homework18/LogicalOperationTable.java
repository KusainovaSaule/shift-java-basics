package homework18;

public class LogicalOperationTable {
    public static void main(String[] args) {
        System.out.println("P\tQ\tP AND Q\tP OR Q\tP XOR Q\tNOT P");

        boolean p = false;
        boolean q = false;
        System.out.println(p + "\t" + q + "\t" + (p && q) + "\t" + (p || q) + "\t" + (p ^ q) + "\t" + (!p));

        p = true;
        q = false;
        System.out.println(p + "\t" + q + "\t" + (p && q) + "\t" + (p || q) + "\t" + (p ^ q) + "\t" + (!p));

        p = false;
        q = true;
        System.out.println(p + "\t" + q + "\t" + (p && q) + "\t" + (p || q) + "\t" + (p ^ q) + "\t" + (!p));

        p = true;
        q = true;
        System.out.println(p + "\t" + q + "\t" + (p && q) + "\t" + (p || q) + "\t" + (p ^ q) + "\t" + (!p));
    }
}