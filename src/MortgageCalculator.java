public class MortgageCalculator {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private final int principal;
    private final float annualInterest;
    private final byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = (short) getNumberOfPayments();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }


    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = (short) getNumberOfPayments();

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }

    public byte getYears() {
        return years;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / MONTHS_IN_YEAR / PERCENT;
    }
}
