package service;

import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repository.AccountRepository;
import repository.TransactionRepository;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listTransactions(Model model){

        System.out.println(transactionRepository.count());

        model.addAttribute("transactions", transactionRepository.findAll());
        model.addAttribute("accounts", accountRepository.findAll());
        return "transactions/list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id){
        transactionRepository.deleteById(id);
        return new ModelAndView("redirect:/transactions");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,
                       Model model) {
        Transaction transaction =  transactionRepository.findById(id).orElse(null);
        model.addAttribute("transaction", transaction);
        return "transactions/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(
            @RequestParam("transaction_id") Integer id,
            @RequestParam("note") String note,
            @RequestParam("datetimeH") String date,
            @RequestParam("time") String time
    ) {
        System.out.println("date: " + date);
        System.out.println("time: " + time);
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        transaction.setNote(note);

        try{
            String dateString = date + " " + time;
            System.out.println(dateString);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date result =  df.parse(dateString);
            System.out.println(result);
            long milliseconds3 = result.getTime();
            System.out.println(milliseconds3);
            transaction.setDatetime(milliseconds3);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        transactionRepository.save(transaction);
        return new ModelAndView("redirect:/transactions");
    }

}
