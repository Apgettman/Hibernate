
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public void createEmployee(Employee employee) {
        try (Session session = (Session) HibernateSessionUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        return HibernateSessionUtil.getSessionFactory().
                openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployee() {

        List<Employee> employeeList = (List<Employee>) HibernateSessionUtil.getSessionFactory()
                .openSession().createQuery("From Employee").list();

        return employeeList;
    }

    @Override
    public void correctiveEmployeeById(Employee employee) {
        try (Session session = (Session) HibernateSessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployeeById(Employee employee) {
        try (Session session = (Session) HibernateSessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
