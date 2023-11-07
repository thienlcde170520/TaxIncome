
package Repository;

import DataAccess.TaxDao;
import model.User;

public class TaxRepository implements ITaxRepository{

    @Override
    public void taxIncome(User user) {
        TaxDao.Instance().inputInformation(user.getParentList(), user.getChildList(), user);
        double parentDeduction = TaxDao.Instance().parentDeduction(user.getParentList(), user);
        double childDeduction = TaxDao.Instance().childDeduction(user.getChildList(), user);
        double totalDeduction = TaxDao.Instance().totalDeduction(parentDeduction, childDeduction);
        double taxIncome = TaxDao.Instance().taxIncome(user.getTotalIncome(), totalDeduction);
        double totalTax = TaxDao.Instance().totalTax(taxIncome, user);
        System.out.println("-------------------Result-----------------");
        System.out.printf("Total income: %.2f\n",user.getTotalIncome());
        if (user.isHasSiblingRegister()) {
            System.out.println("Parent Deduction: 0(Sibling already register)");
        } else if (!user.isIsFamily()) {
            System.out.println("Parent Deduction: 0(No family)");
        } else {
            System.out.printf("Parent Deduction: %.2f\n",parentDeduction);
        }

        if (!user.isHasChild()) {
            System.out.println("Child Deduction: 0(You have no children)");
        } else {
            System.out.printf("Child Deduction: %.2f\n",childDeduction);
        }
        System.out.println("Self deduction: 11000000");
        System.out.printf("Total Deduction: %.2f\n",totalDeduction);
        System.out.printf("Tax income: %.2f\n",taxIncome);
        if (taxIncome <= 0) {
            System.out.println("Tax(0%): 0");
        }
        else if (taxIncome < 4000000) {
            System.out.printf("Tax(5%%): %.2f\n",totalTax);
        }
        else if (taxIncome >= 4000000 && taxIncome < 6000000) {
            System.out.printf("Tax(8%%): %.2f\n" ,totalTax);
        }
        else if (taxIncome >= 6000000 && taxIncome < 10000000) {
            System.out.printf("Tax(10%%): %.2f\n" ,totalTax);
        } else {
            System.out.printf("Tax(20%%): %.2f\n" ,totalTax);
        }
    }
}
    

