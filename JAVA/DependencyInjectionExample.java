package JAVA;

interface CustomerRepository{
     void findCustomerById(int id);
}
class CustomerRepositoryImpl implements CustomerRepository{

    @Override
    public void findCustomerById(int id) {
        if(id==1) System.out.println("Alice");
        else if(id==2) System.out.println("Rakesh");
        else System.out.println("No customer found");

    }
}

class CustomerService{
    CustomerRepository customerRepository;
   public CustomerService(CustomerRepository customerRepository){
       this.customerRepository=customerRepository;
   }

   public void findCustomer(int id){
       customerRepository.findCustomerById(id);
   }
}



public class DependencyInjectionExample {
    public static void main(String[] args){
        CustomerRepository customerRepository=new CustomerRepositoryImpl();
        CustomerService service=new CustomerService(customerRepository);
        service.findCustomer(1);
    }
}
