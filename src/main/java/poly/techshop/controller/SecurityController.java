package poly.techshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
@RequestMapping("/security/login/form")
public String LoginForm(Model model) {
model.addAttribute("message","vui long dang nhap !");
return "security/login";
}

@RequestMapping("/security/login/success")
public String LoginSuccess(Model model) {
model.addAttribute("message","dang nhap thanh cong !");
return "security/login";
}


@RequestMapping("/security/login/error")
public String LoginError(Model model) {
model.addAttribute("message","Sai thong tin dang nhap !");
return "security/login";
}

@RequestMapping("/security/unauththoried")
public String unauththoried(Model model) {
model.addAttribute("message","Ban khong co quyen truy xuat !");
return "security/login";
}
		
@RequestMapping("/security/logoff/success")
public String logoffSuccess(Model model) {
model.addAttribute("message","Ban da dang xuat !");
return "security/login";
}

}
