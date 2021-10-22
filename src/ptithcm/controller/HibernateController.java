//package ptithcm.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.transaction.Transactional;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.support.PagedListHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import ptithcm.entity.Staff;
//
//import ptithcm.entity.UserModel;
//
//@Transactional
//@Controller
//@RequestMapping("user")
//public class HibernateController {
//
//	@Autowired
//	SessionFactory factory;
//
//	
//	// get user
//	@RequestMapping("index")
//	public String index(ModelMap model) {
//		Session session = factory.openSession();
//
//		// không xài nhưng mà nó đòi thì phải cho
//		Transaction t = session.beginTransaction();
//
//		String hql = "FROM User";
//		Query query = session.createQuery(hql);
//		ArrayList<UserModel> listUser = (ArrayList<UserModel>) query.list();
//
//		model.addAttribute("users", listUser);
//
//		return "views/demo";
//	}
//
//	@RequestMapping("/insert")
//	public String insert(ModelMap model) {
//		UserModel user = new UserModel();
//		model.addAttribute("user", user);
//		return "views/insert";
//	}
//
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	public String insertUser(ModelMap model, @ModelAttribute("user") UserModel user) {
//		Session session = factory.getCurrentSession();
//		session.beginTransaction();
//		try {
//			session.save(user);
//			session.getTransaction().commit();
//			model.addAttribute("message", "Thêm mới thành công!");
//		} catch (Exception ex) {
//			session.getTransaction().rollback();
//			model.addAttribute("message", "Thêm thất bại!");
//		}
//		return "views/insert";
//	}
//
//	@RequestMapping(value = "/delete/{username}")
//	public String delete(ModelMap model, @PathVariable int username) {
//	
//		if (user == null)
//			return "redirect:/user/insert.htm";
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		session.delete(user);
//		t.commit();
//		return "redirect:/user/index.htm";
//	}
//
//	public User getUserByUsername(int username) {
//		String hql = "from User where username = :username";
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		Query query = session.createQuery(hql);
//		query.setParameter("username", username);
//		User user = (User) query.list().get(0);
//		return user;
//	}
//
//	// get staff
//	public List<Staff> getAllUsers() {
//		Session session = factory.openSession();
//
//		// không xài nhưng mà nó đòi thì phải cho
//		Transaction t = session.beginTransaction();
//
//		String hql = "FROM Staff";
//		Query query = session.createQuery(hql);
//		List<Staff> list = query.list();
//		return list;
//	}
//	
//	public List<User> getListUser() {
//		Session session = factory.openSession();
//
//		// không xài nhưng mà nó đòi thì phải cho
//		Transaction t = session.beginTransaction();
//
//		String hql = "FROM User";
//		Query query = session.createQuery(hql);
//		List<User> list = query.list();
//		return list;
//	}
//	
//	@RequestMapping(value = {"hi", "/{page}"}, method = RequestMethod.GET)
//	  public String showUser(@PathVariable("page") String page,
//			  HttpServletRequest request, HttpServletResponse response) {
//	    ModelAndView mv = new ModelAndView();
//	    PagedListHolder<User> userList;
//	    if(page == null) {
//	      userList = new PagedListHolder<User>();
//	      List<User> usersList = getListUser();
//	      // Setting the source for PagedListHolder
//	      userList.setSource(usersList);
//	      userList.setPageSize(2);
//	      // Setting PagedListHolder instance to session
//	      request.getSession().setAttribute("userList", userList);
//	    }else if(page.equals("prev")) {
//	      // get the user list from session
//	      userList = (PagedListHolder<User>)request.getSession().getAttribute("userList");
//	      // switch to previous page
//	      userList.previousPage();
//	    }else if(page.equals("next")) {
//	      userList = (PagedListHolder<User>)request.getSession().getAttribute("userList");
//	      // switch to next page
//	      userList.nextPage();
//	    }else {
//	      int pageNum = Integer.parseInt(page);
//	      userList = (PagedListHolder<User>)request.getSession().getAttribute("userList");
//	      // set the current page number
//	      // page number starts from zero in PagedListHolder that's why subtracting 1
//	      userList.setPage(pageNum - 1);
//	    }
//	    
//	    
//	    return "views/user";
//	  }
//}
