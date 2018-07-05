package controller;

import model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SpringMainController {

    @RequestMapping(value = "/hello/{name}")
    @ResponseBody
    String hello(@PathVariable("name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello world!";
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            System.err.println("Error: POST call with empty customer");
            // TODO: Returner error response
        }

        // TEST
//        if (customer != null) {
//            System.out.println("TEST: " + customer.toString());
//        }

        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringMainController.class, args);
    }
}
