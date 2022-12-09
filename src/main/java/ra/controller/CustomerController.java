package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Customer;
import ra.model.service.customerService;

import java.util.List;


@Controller
@RequestMapping("CustomerController")
public class CustomerController {
    @Autowired
    private customerService customerService;

    @RequestMapping(value = "getAll")
    public String getAll (Model model){
        List<Customer> listCustomer = customerService.getAll();
        model.addAttribute("listCustomer",listCustomer);
        return "customer";
    }

    @RequestMapping(value = "getByID")
    public String getByID (Model model, int customerID){
        Customer customer = customerService.getByID(customerID);
        model.addAttribute("customer",customer);
        return "customerDetail";
    }
}
