public class BackusNaurForm {
    private final String[] TIERE;
    private final String[] VERBEN;
    private final String[] ADJEKTIVE;
    private final String[] ORTE;

    private final String tier;
    private final String verb;
    private final String adjektiv;
    private final String ort;
    private final String result;

    public static void main(String[] args) {
        new BackusNaurForm().print();
        new BackusNaurForm().print();
        new BackusNaurForm().print();
    }

    BackusNaurForm() {
        TIERE = new String[]{"Das Schaf", "Die Kuh", "Das Schwein"};
        VERBEN = new String[]{"steht", "spielt", "schlaeft"};
        ADJEKTIVE = new String[]{"interessiert", "hungrig", "freudig"};
        ORTE = new String[]{"im Stall", "auf der Weide", "auf dem Bauernhof"};

        tier = TIERE[(int) (Math.random() * TIERE.length)];
        verb = VERBEN[(int) (Math.random() * VERBEN.length)];
        adjektiv = ADJEKTIVE[(int) (Math.random() * ADJEKTIVE.length)];
        ort = ORTE[(int) (Math.random() * ORTE.length)];

        result = tier + " " + verb + " " + adjektiv + " " + ort + "\n";
    }

    void print() {
        System.out.println(result);
    }
}
