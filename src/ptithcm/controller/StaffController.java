package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.entity.*;

@Transactional
@Controller
@RequestMapping("lab6")
public class StaffController {
	
	@Autowired
	SessionFactory factory;

	@RequestMapping("staff")
	public String indexStaff(HttpServletRequest request, ModelMap model) {
		
		//gọi lại hàm getStaffs() để lấy danh sách dứ liệu
		List<Staff> staffs = this.getStaffs();
		
		//bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(staffs);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(2);
		pagedListHolder.setPageSize(3);
		
		
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "lab6/staff";
	}
	
	@RequestMapping("/staff/report")
	public String report(HttpServletRequest request, ModelMap model) {
		
		//gọi lại hàm getReport() để lấy danh sách dữ liệu
		List<Object[]> report = this.getReport();
		
		//bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(report);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(8);
		pagedListHolder.setPageSize(5);
		
		
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "lab6/report";
	}
	
	@RequestMapping(value="/staff", params = "btnSearch")
	public String searchStaffs (HttpServletRequest request, ModelMap model) {
		
		String staff_name = request.getParameter("searchInput");
		
		//gọi lại hàm getStaffs() để lấy danh sách dữ liệu
		List<Staff> staffs = this.searchStaffs(staff_name);
		
		//bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(staffs);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		
		
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "lab6/staff";
	}
	
	public List<Staff> getStaffs() {
		Session session = factory.getCurrentSession();

		// không xài nhưng mà nó đòi thì phải cho
		Transaction t = session.beginTransaction();
		String hql = "from Staff";
		Query query = session.createQuery(hql);
		
		List<Staff> list = query.list();
		return list;
	}
	
	public List<Object[]> getReport() {
		Session session = factory.openSession();

		// không xài nhưng mà nó đòi thì phải cho
		Transaction t = session.beginTransaction();
		String hql =	"select r.staff.id, " +
						"sum(case when r.type=1 then 1 else 0 end), " +
						"sum(case when r.type=0 then 1 else 0 end) " +
						"from Record r " +
						"group by r.staff.id";
		Query query = session.createQuery(hql);
		
		List<Object[]> list = query.list();
		return list;
	}
	
	public List<Staff> searchStaffs(String name) {
		
		Session session = factory.getCurrentSession();
		// không xài nhưng mà nó đòi thì phải cho
		Transaction t = session.beginTransaction();
		String hql = "from Staff where name like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + name + "%");
		
		List<Staff> list = query.list();
		return list;
	}
}
