package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Not1;
import com.example.demo.entity.User;
import com.example.demo.model.AdminloginForm;
import com.example.demo.model.LoginForm;
import com.example.demo.model.NotForm;
import com.example.demo.model.SignupForm;
import com.example.demo.model.UserUpdateForm;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.NotRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class HelloWorldController {

	static List<User> aktifList;
	static List<User> pasifList;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private NotRepository notRepo;

	@Autowired
	private AdminRepository adminRepo;

	@GetMapping("/index")
	public String ilkSayfa(Model model) {
		return "index";
	}

	@GetMapping(path = "/kayit")
	public String getSignUpPage() {
		return "userRegister";
	}

	@GetMapping(path = "/userlogin")
	public String getuserLogin() {

		return "userLogin";
	}

	@GetMapping(path = "/adminlogin")
	public String getadminLogin() {
		Admin admin = null;

		admin = new Admin("root", "1234");

		adminRepo.save(admin);
		return "adminLogin";
	}

	@PostMapping(path = "/adminpanel")
	public String getadminPanel() {

		return "adminPanel";
	}

	@GetMapping(path = "/userpanel")
	public String getuserPanel() {

		return "userPanel";
	}

	@PostMapping(path = "/notekle")
	public String getNotekle(NotForm notform, Model m) {

		Not1 not = null;

		if (null != notform) {
			not = new Not1(notform.getBaslik(), notform.getNot());
		}

		notRepo.save(not);

		List<Not1> list = notRepo.findAll();
		m.addAllAttributes(list);

		ArrayList<Object> objects = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			System.err.println(list.get(i).getBaslik() + " " + list.get(i).getNot1());
			objects.add(list.get(i));
		}
		m.addAttribute("objects", objects);

		return "notlisteleme";
	}

	@PostMapping(path = "/login")
	public String getloginPanel(LoginForm loginform) {
		User user = null;
		String deger = "userLoginHata";
		if (loginform != null) {
			List<User> userList = userRepo.findAll();
			for (int i = 0; i < userList.size(); i++) {
				if (loginform.getEmailId().equals(userList.get(i).getEmailId())) {
					if (loginform.getPassword().equals(userList.get(i).getPassword())) {
						if (userList.get(i).isAktiflikDurumu() == true) {
							deger = "userPanel";
						} else {
							deger = "userPasif";
						}

					}
				}
			}
		}
		return deger;
	}

	@PostMapping(path = "/adminlogin")
	public String getadminPanel(AdminloginForm adminloginform, Model m) {
		Admin admin = null;

		String deger = "adminLoginHata";
		if (adminloginform != null) {
			List<Admin> adminList = adminRepo.findAll();
			for (int i = 0; i < adminList.size(); i++) {
				if (adminloginform.getEmail().equals(adminList.get(i).getEmail())) {
					if (adminloginform.getParola().equals(adminList.get(i).getParola())) {

						List<User> USERList = userRepo.findAll();
						m.addAttribute("aktifList", USERList);
						List<User> USERlist = userRepo.findAll();
						m.addAllAttributes(USERlist);

						ArrayList<Object> ob1 = new ArrayList<>();

						for (int K = 0; K < USERlist.size(); K++) {
							System.err.println(USERlist.get(K).getFirstName() + " " + USERlist.get(K).getLastName());
							if (USERlist.get(K).isAktiflikDurumu() == true)
								ob1.add(USERlist.get(K));
						}
						m.addAttribute("obje", ob1);

						deger = "adminPanel";
					}
				}
			}
		}
		return deger;
	}

	@PostMapping(value = "/updateUser")
	public String getUpdateUser(UserUpdateForm user) {
		if (user.getIslem().equals("1")) {

			User nesne = userRepo.getOne(user.getId());
			nesne.setAktiflikDurumu(true);
			userRepo.save(nesne);
			System.err.println("Aktif hale getirildi.");

		}
		if (user.getIslem().equals("2")) {

			User nesne = userRepo.getOne(user.getId());
			nesne.setAktiflikDurumu(false);
			userRepo.save(nesne);
			System.err.println("Pasif hale getirildi.");
		}
		return "adminLogin";

	}

	@PostMapping(path = "/notlisteleme")
	public String getnotListele() {
		return "notlisteleme";
	}

	@PostMapping(path = "/signup")
	public String submitSignup(SignupForm signupForm) {
		User user = null;
		if (null != signupForm) {
			user = new User(signupForm.getFirstName(), signupForm.getLastName(), signupForm.getEmailId(),
					signupForm.getPassword(), true);
		}
		userRepo.save(user);
		return "userLogin";
	}

}
