package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppMain {

	static User userObj;
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = HibernateUtil.getSessionFactory().openSession();
			sessionObj.beginTransaction();

//			for (int i = 101; i <= 105; i++) {
//				userObj = new User();
//				userObj.setId(i);
//				userObj.setUsername("Editor " + i);
//				userObj.setCreatedBy("Administrator");
//				// userObj.setCreatedDate(new Date());
//
//				sessionObj.save(userObj);
//			}
//			userObj = new User();
//			userObj.setUsername("Minh Hiếu");
//			userObj.setFullname("Dương Minh Hiếu");
//			userObj.setCreatedAt(null);
//			userObj.setModifiedAt(null);
//			sessionObj.save(userObj);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		    // Begin a unit of work
		    session.beginTransaction();
		 
		    // HQL
		    String hql = "FROM users";
		    List<User> users = session.createQuery(hql, User.class).list();


		    session.getTransaction().commit();
		    
		    // Xử lý kết quả (nếu cần)
		    for (User user : users) {
		        System.out.println(user);
		    }
		} catch (Exception e) {
		    // Xử lý ngoại lệ (in hoặc log thông báo lỗi)
		    e.printStackTrace();
		}
//		updateUser(102, "Dương Minh Hi");
//		System.out.println("Danh sach sau khi sua: \n");
//		selectUser();
//		deleteUser(105);
	}
}
