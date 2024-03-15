package jp.ac.ohara.E.seisaku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.ac.ohara.E.seisaku.model.GakuseiHyou;
import jp.ac.ohara.E.seisaku.model.SeisekiHyou;
import jp.ac.ohara.E.seisaku.model.SyusekiHyou;
import jp.ac.ohara.E.seisaku.service.GakuseiService;
import jp.ac.ohara.E.seisaku.service.SeisekiService;
import jp.ac.ohara.E.seisaku.service.SyusekiService;

@Controller
public class MainController {
	
	@Autowired
	private GakuseiService gakuseiservice;
	@Autowired
	private SeisekiService seisekiservice;
	@Autowired
	private SyusekiService syusekiservice;
	

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "こんにちは");
		return "top";
	}

	//  //("")の中はlocalhost:8080の後に続くURLを記述　(localhost:8080/form/に表示させたいので"/form/")
	//    @GetMapping("/form/")
	//    //そのページで使うmodelのインスタンス化　(学生表登録フォームなのでGakuseiHyouをインスタンス化)
	//      public ModelAndView add(GakuseiHyou gakuseihyou, ModelAndView model) {
	//          model.addObject("gakuseihyou", gakuseihyou);
	//          // ()の中にアクセスしたいHTMLファイルの.htmlを省いた名前を記述
	//          model.setViewName("form");
	//          return model;

	@GetMapping("/login/")
	public ModelAndView add5(SyusekiHyou syusekihyou, ModelAndView model) {
	 	model.addObject("syusekihyou", syusekihyou);
	 	model.setViewName("login");
	 	return model;   
	 }
	  
	  
	@GetMapping("/recordslist/")
	public ModelAndView add(SeisekiHyou seisekihyou, ModelAndView model) {
		model.addObject("seisekihyou", seisekihyou);
		model.setViewName("recordslist");
		return model;
	}

	@GetMapping("/setrecords/")
	public ModelAndView add1(SeisekiHyou seisekihyou, ModelAndView model) {
		model.addObject("seisekihyou", seisekihyou);
		model.setViewName("setrecords");
		return model;
	}

	@GetMapping("/setsyuseki/")
	public ModelAndView add(SyusekiHyou syusekihyou, ModelAndView model) {
		model.addObject("syusekihyou", syusekihyou);
		model.setViewName("setsyuseki");
		return model;
	}

	@GetMapping("/studentlist/")
    //そのページで使うmodelのインスタンス化　(学生表登録フォームなのでGakuseiHyouをインスタンス化)
      public String add2(Model model) {
		System.out.println(gakuseiservice.getGakuseiList().toString());
          model.addAttribute("gakuseiList", gakuseiservice.getGakuseiList());
          return "studentlist";
	}

	@GetMapping("/syusekidetail/")
	public ModelAndView add3(SyusekiHyou syusekihyou, ModelAndView model) {
		model.addObject("syusekihyou", syusekihyou);
		model.setViewName("syusekidetail");
		return model;
	}

	@GetMapping("/syusekilist/")
	public ModelAndView add4(SyusekiHyou syusekihyou, ModelAndView model) {
		model.addObject("syusekihyou", syusekihyou);
		model.setViewName("syusekilist");
		return model;
	}

	@GetMapping("/top/")
	public String index1(Model model) {
		model.addAttribute("", "");
		return "top";
	}

	@GetMapping("/form/")
	public ModelAndView add5(GakuseiHyou gakuseihyou, ModelAndView model) {
		model.addObject("gakuseihyou", gakuseihyou);
		model.setViewName("form");
		return model;
	}

	@PostMapping("/form/")
	public String add(@Validated @ModelAttribute @NonNull GakuseiHyou gakuseihyou, RedirectAttributes result,
			ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.gakuseiservice.save(gakuseihyou);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";

	}
	
	@PostMapping("/setrecords/")
	public String add7(@Validated @ModelAttribute @NonNull SeisekiHyou seisekihyou, RedirectAttributes result,
			ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.seisekiservice.save(seisekihyou);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";

	}
	
	@PostMapping("/setsyuseki/")
	public String add8(@Validated @ModelAttribute @NonNull SyusekiHyou syusekihyou, RedirectAttributes result,
			ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.syusekiservice.save(syusekihyou);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";
		
		
	}
	
}
