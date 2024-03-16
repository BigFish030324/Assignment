public class ARunCodeHere {
    
    static MainPage a;

    static PageAdmin b;
    static PageAdmin_Register c;
    static PageAdmin_Edit d;
    static PageAdmin_Appointment_TABLE e;
    static PageAdmin_Appointment f;
    static PageAdmin_Feedback g;
    static PageAdmin_Payment h;
    static RegisterSuccess i;
    static EditConfirmation j;

    static PageTechnician k;
    static PageTechnician_Appointment_TABLE l;
    static PageTechnician_Appointment m;
    static PageTechnician_Feedback n;
    static PageTechnician_Payment o;

    static PageCustomer p;
    static PageCustomer_Appointment q;
    static PageCustomer_Feedback r;
    static PageCustomer_Payment s;

    static AboutUs z;

    public static void main(String[] args) {
        a = new MainPage();

        b = new PageAdmin();
        c = new PageAdmin_Register();
        d = new PageAdmin_Edit();
        e = new PageAdmin_Appointment_TABLE();
        f = new PageAdmin_Appointment();
        g = new PageAdmin_Feedback();
        h = new PageAdmin_Payment();
        i = new RegisterSuccess();
        j = new EditConfirmation();

        k = new PageTechnician();
        l = new PageTechnician_Appointment_TABLE();
        m = new PageTechnician_Appointment();
        n = new PageTechnician_Feedback();
        o = new PageTechnician_Payment();

        p = new PageCustomer();
        q = new PageCustomer_Appointment();
        r = new PageCustomer_Feedback();
        s = new PageCustomer_Payment();

        z = new AboutUs();



        MainPage.container.setVisible(true);

        PageAdmin.container.setVisible(false);
        PageAdmin_Register.container.setVisible(false);
        PageAdmin_Edit.container.setVisible(false);
        PageAdmin_Appointment_TABLE.container.setVisible(false); // Issue on table heading
        PageAdmin_Appointment.container.setVisible(false);
        PageAdmin_Feedback.container.setVisible(false); // Change feedback button to addable every new feedback
        PageAdmin_Payment.container.setVisible(false);
        RegisterSuccess.container.setVisible(false);
        EditConfirmation.container.setVisible(false);

        PageTechnician.container.setVisible(true);
        PageTechnician_Appointment_TABLE.container.setVisible(false); // Issue on table heading
        PageTechnician_Appointment.container.setVisible(false);
        PageTechnician_Feedback.container.setVisible(false);
        PageTechnician_Payment.container.setVisible(false);

        PageCustomer.container.setVisible(true);
        PageCustomer_Appointment.container.setVisible(false);
        PageCustomer_Feedback.container.setVisible(false);
        PageCustomer_Payment.container.setVisible(false);

        AboutUs.container.setVisible(false); // Need to link OK back to MainPage
    }    
}
