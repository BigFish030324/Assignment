public class ARunCodeHere {
    
    static MainPage a;
    static EditConfirmation j;
    static PageAdmin_PaymentHistory b;
    static PageTechnician_History c;

    public static void main(String[] args) {
        a = new MainPage();
        j = new EditConfirmation();
        b = new PageAdmin_PaymentHistory();
        c = new PageTechnician_History();
        MainPage.container.setVisible(true);
        EditConfirmation.container.setVisible(false);
        PageAdmin_PaymentHistory.container.setVisible(false);
        PageTechnician_History.container.setVisible(false);
    }    
}
