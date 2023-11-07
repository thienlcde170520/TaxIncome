
package controller;

import view.Menu;
import Repository.ITaxRepository;
import Repository.TaxRepository;
import model.User;

public class TaxManager extends Menu<String>{
    static String[] mc = {"Tax.","Exit."};
    ITaxRepository tax;
    User user;
    public TaxManager(){
        super("====== Tax Program ======",mc);
        tax = new TaxRepository();
        user = new User();
    }

    @Override
    public void execute(int n) {
        switch (n){
            case 1:
                tax.taxIncome(user);
                break;
            case 2:
                System.out.println("Extting program successfully...!");
                System.exit(0);
        }
    }
}
